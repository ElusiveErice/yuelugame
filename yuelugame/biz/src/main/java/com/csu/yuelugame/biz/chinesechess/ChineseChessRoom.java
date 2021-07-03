package com.csu.yuelugame.biz.chinesechess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 中国象棋房间
 * 管理房间状态
 * 记录并管理棋局
 */
public class ChineseChessRoom {

    /**
     * 定义房间状态枚举
     */
    public enum ChineseChessRoomStateEnum {
        EMPTY, FULL, GAME
    }

    public static final long DEFAULT_ID = -1;
    public static final long DEFAULT_STEP_TIME_TOTAL = 3;//默认步时60秒
    public static final long DEFAULT_ROOM_TIME_TOTAL = 1200;//默认局时1200秒
    public static final int MAX_PLAYER_NUMBER = 2;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Map<Long, Player> playerMap = new HashMap<>();//玩家id查找表
    private final ChineseChessPieceEnum[][] chessBoard = new ChineseChessPieceEnum[9][10];//棋盘
    private final Queue<ChineseChessStep> chessManual = new LinkedList<>();//棋谱
    private final Timer timer = new Timer();

    private long id;
    private String name;
    private ChineseChessRoomStateEnum state;
    private long stepTime;//步时
    private long roomTime;//局时


    public ChineseChessRoom() {
        this(DEFAULT_ID);
    }

    public ChineseChessRoom(long id) {
        this.id = id;
        this.name = "中国象棋房间" + this.id;
        this.state = ChineseChessRoomStateEnum.EMPTY;
        this.stepTime = DEFAULT_STEP_TIME_TOTAL;
        this.roomTime = DEFAULT_ROOM_TIME_TOTAL;
    }

    /**
     * 处理用户进入房间事件
     *
     * @param userId 进入房间的用户id
     * @return 是否成功进入房间
     */
    public boolean onEnter(long userId) {
        if (state != ChineseChessRoomStateEnum.EMPTY) {
            return false;
        }
        Player player = new Player(userId);
        this.playerMap.put(userId, player);
        if (this.playerMap.size() == MAX_PLAYER_NUMBER) {
            this.state = ChineseChessRoomStateEnum.FULL;
        }

        return true;
    }

    /**
     * 处理玩家退出事件
     *
     * @param userId 玩家的用户id
     * @return 是否成功退出房间
     */
    public boolean onExit(long userId) {
        if (this.state == ChineseChessRoomStateEnum.GAME) {
            return false;
        }
        Player player = this.playerMap.get(userId);
        if (player == null) {
            return false;
        }
        this.playerMap.remove(userId);
        this.state = ChineseChessRoomStateEnum.EMPTY;
        return true;
    }

    /**
     * 处理玩家准备事件
     *
     * @param userId 玩家的用户id
     * @return 是否成功准备
     */
    public boolean onReady(long userId) {
        if (this.state == ChineseChessRoomStateEnum.GAME) {
            return false;
        }
        Player player = this.playerMap.get(userId);
        if (player == null) {
            return false;
        }
        player.setReady(true);

        if (this.state == ChineseChessRoomStateEnum.FULL) {
            boolean flag = true;
            for (Player anyPlayer : this.playerMap.values()) {
                if (!anyPlayer.isReady()) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                this.state = ChineseChessRoomStateEnum.GAME;
                startGame();
            }
        }

        return true;
    }

    /**
     * 处理玩家取消准备事件
     *
     * @param userId 玩家的用户id
     * @return 是否成功取消
     */
    public boolean onCancelReady(long userId) {
        if (this.state == ChineseChessRoomStateEnum.GAME) {
            return false;
        }
        Player player = this.playerMap.get(userId);
        if (player == null) {
            return false;
        }
        player.setReady(false);
        return true;
    }

    /**
     * 处理移动棋子事件
     *
     * @param userId 玩家用户id
     * @param x1     起点位置x坐标
     * @param y1     起点位置y坐标
     * @param x2     终点位置x坐标
     * @param y2     终点位置y坐标
     * @return 是否成功移动
     */
    public boolean onMove(long userId, int x1, int y1, int x2, int y2) {
        //玩家不存在
        Player player = playerMap.get(userId);
        if (player == null) {
            return false;
        }

        //起点是否存在
        if (x1 < Coord.MIN_X || x1 > Coord.MAX_X || y1 < Coord.MIN_Y || y1 > Coord.MAX_Y) {
            return false;
        }
        Coord startPoint = new Coord(x1, y1);

        //终点是否存在
        if (x2 < Coord.MIN_X || x2 > Coord.MAX_X || y2 < Coord.MIN_Y || y2 > Coord.MAX_Y) {
            return false;
        }
        Coord endPoint = new Coord(x2, y2);


        //起点棋子是否存在且颜色为执子人颜色
        ChineseChessPieceEnum startPiece = chessBoard[x1][y1];
        if (startPiece == null || startPiece.getColor() != playerMap.get(userId).getColor()) {
            return false;
        }

        //终点是否无棋子或者与起点棋子颜色不同
        ChineseChessPieceEnum endPiece = chessBoard[x2][y2];
        if (endPiece != null && endPiece.getColor() == startPiece.getColor()) {
            return false;
        }

        if (!isConformRules(startPiece, startPoint, endPoint)) {
            return false;
        }

        ChineseChessStep step = new ChineseChessStep();
        step.setStartPiece(startPiece);
        step.setEndPiece(endPiece);
        step.setStartPoint(startPoint);
        step.setEndPoint(endPoint);
        chessBoard[step.getEndPoint().getX()][step.getEndPoint().getY()] = step.getStartPiece();
        chessBoard[step.getStartPoint().getX()][step.getStartPoint().getY()] = null;
        chessManual.offer(step);

        //判断胜负
        if (ChineseChessPieceEnum.GREEN_KING == step.getEndPiece() || ChineseChessPieceEnum.RED_KING == step.getEndPiece()) {
            logger.info("游戏结束," + step.getEndPiece().getColor().toString() + "方获胜。" + toString());
            endGame(player);
        } else {
            //TODO 计时器反转
        }


        return true;
    }

    /**
     * 处理悔棋事件
     *
     * @param userId 玩家用户id
     * @return 是否悔棋成功
     */
    public boolean onMoveBack(long userId) {
        //玩家不存在
        Player player = playerMap.get(userId);
        if (player == null) {
            return false;
        }

        //步骤为空，游戏才开始
        ChineseChessStep step = chessManual.poll();
        if (step == null) {
            return false;
        }

        //上一步不是该玩家的步骤，不允许悔棋
        if (step.getStartPiece().getColor() != player.getColor()) {
            return false;
        }

        //棋盘按步骤倒行
        chessBoard[step.getEndPoint().getX()][step.getEndPoint().getY()] = step.getEndPiece();
        chessBoard[step.getStartPoint().getX()][step.getStartPoint().getY()] = step.getStartPiece();

        //TODO 计时器重新设置
        return true;
    }

    /**
     * 判断是否符合象棋规则
     *
     * @param piece      棋子
     * @param startPoint 起点
     * @param endPoint   终点
     * @return 是否符合
     */
    private boolean isConformRules(ChineseChessPieceEnum piece, Coord startPoint, Coord endPoint) {
        //起始位置到终点位置的距离
        int distanceX = Math.abs(startPoint.getX() - endPoint.getX());
        int distanceY = Math.abs(startPoint.getY() - endPoint.getY());
        int distance = distanceX + distanceY;

        //两个位置之间棋子的数量
        int[] barriers = countBarriers(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());

        //是否在九宫格中
        boolean inRedSquare = endPoint.getX() >= 3 && endPoint.getX() <= 5 && endPoint.getY() >= 7;
        boolean inGreenSquare = endPoint.getX() >= 3 && endPoint.getX() <= 5 && endPoint.getY() <= 2;

        switch (piece) {
            case RED_KING:
                //帅
                return distance == 1 && inRedSquare;
            case GREEN_KING:
                //将
                return distance == 1 && inGreenSquare;
            case RED_PAWN:
                //兵
                if (startPoint.getY() >= 5) {
                    return distance == 1 && endPoint.getY() <= startPoint.getY();
                } else {
                    return distance == 1 && endPoint.getY() < startPoint.getY();
                }
            case GREEN_PAWN:
                //卒
                if (startPoint.getY() <= 4) {
                    return distance == 1 && endPoint.getY() >= startPoint.getY();
                } else {
                    return distance == 1 && endPoint.getY() > startPoint.getY();
                }
            case RED_ROOK:
            case GREEN_ROOK:
                //车
                return barriers[0] == 0 && barriers[1] == 0;
            case RED_CANNON:
            case GREEN_CANNON:
                //炮
                if (this.chessBoard[endPoint.getX()][endPoint.getY()] == null) {
                    //如果终点位置没有棋子，则为走棋
                    return barriers[0] == 0 && barriers[1] == 0;
                } else {
                    //如果终点位置有棋子，则为吃子
                    return barriers[0] == 1 && barriers[1] == 0;
                }
            case RED_KNIGHT:
            case GREEN_KNIGHT:
                //马
                if (distanceX == 1 && distanceY == 2) {
                    return chessBoard[startPoint.getX()][(startPoint.getY() + endPoint.getY()) / 2] == null;
                } else if (distanceX == 2 && distanceY == 1) {
                    return chessBoard[(startPoint.getX() + endPoint.getX()) / 2][startPoint.getY()] == null;
                } else {
                    return false;
                }

            case RED_ELEPHANT:
                if (endPoint.getY() <= 4) {
                    return false;
                }
            case GREEN_ELEPHANT:
                //相
                if (endPoint.getY() >= 5) {
                    return false;
                }
                if (distanceX != 2 || distanceY != 2) {
                    return false;
                }
                return chessBoard[(startPoint.getX() + endPoint.getX()) / 2][(startPoint.getY() + endPoint.getY()) / 2] == null;
            case RED_MANDARIN:
                return distanceX == 1 && distanceY == 1 && inRedSquare;
            case GREEN_MANDARIN:
                //士
                return distanceX == 1 && distanceY == 1 && inGreenSquare;
            default:
                return false;
        }
    }

    /**
     * 计算两个位置之间的“障碍”棋子数
     *
     * @param x1 起点位置x坐标
     * @param y1 起点位置y坐标
     * @param x2 终点位置x坐标
     * @param y2 终点位置y坐标
     * @return 同色的“障碍‘数和不同色的”障碍“数
     */
    private int[] countBarriers(int x1, int y1, int x2, int y2) {
        int barriers1 = 0;
        int barriers2 = 0;
        if (x1 == x2) {
            if (y1 < y2) {
                for (int y = y1 + 1; y < y2; y++) {
                    if (chessBoard[x1][y] != null) {
                        if (chessBoard[x1][y].getColor() == chessBoard[x1][y1].getColor()) {
                            barriers1++;
                        } else {
                            barriers2++;
                        }
                    }
                }
            } else {
                for (int y = y2 + 1; y < y1; y++) {
                    if (chessBoard[x1][y] != null) {
                        if (chessBoard[x1][y].getColor() == chessBoard[x1][y1].getColor()) {
                            barriers1++;
                        } else {
                            barriers2++;
                        }
                    }
                }
            }
        } else if (y1 == y2) {
            if (x1 < x2) {
                for (int x = x1 + 1; x < x2; x++) {
                    if (chessBoard[x][y1] != null) {
                        if (chessBoard[x][y1].getColor() == chessBoard[x1][y1].getColor()) {
                            barriers1++;
                        } else {
                            barriers2++;
                        }
                    }
                }
            } else {
                for (int x = x2 + 1; x < x1; x++) {
                    if (chessBoard[x][y1] != null) {
                        if (chessBoard[x][y1].getColor() == chessBoard[x1][y1].getColor()) {
                            barriers1++;
                        } else {
                            barriers2++;
                        }
                    }
                }
            }
        }
        return new int[]{barriers1, barriers2};
    }

    /**
     * 计算下一步可以走的所有位置
     *
     * @param coord 棋子的位置
     * @return 所有可行的位置
     */
    private Set<Coord> nextStep(Coord coord) {
        //TODO（先不考虑照将的情况）
        return new HashSet<>();
    }

    /**
     * 开始对局后的初始化工作
     */
    private void startGame() {
        //初始棋盘
        initChessBoard();

        //随机生成红方
        Player player = (Player) this.playerMap.values().toArray()[Math.random() > 0.5 ? 0 : 1];
        player.setColor(ChineseChessPieceColorEnum.RED);

        //开始对局

        //红方启动计时器
        timer.schedule(player.makeTimerTask(), 0, 1000);
    }


    /**
     * 游戏结束后的处理工作
     *
     * @param winner 获胜的玩家
     */
    private void endGame(Player winner) {
        if (winner == null) {
            //和棋
        }
        //TODO
        //中止计时器

    }

    /**
     * 初始化棋局
     */
    private void initChessBoard() {
        chessBoard[0][0] = ChineseChessPieceEnum.RED_ROOK;
        chessBoard[0][1] = ChineseChessPieceEnum.RED_KNIGHT;
        chessBoard[0][2] = ChineseChessPieceEnum.RED_ELEPHANT;
        chessBoard[0][3] = ChineseChessPieceEnum.RED_MANDARIN;
        chessBoard[0][4] = ChineseChessPieceEnum.RED_KING;
        chessBoard[0][5] = ChineseChessPieceEnum.RED_MANDARIN;
        chessBoard[0][6] = ChineseChessPieceEnum.RED_ELEPHANT;
        chessBoard[0][7] = ChineseChessPieceEnum.RED_KNIGHT;
        chessBoard[0][8] = ChineseChessPieceEnum.RED_ROOK;
        chessBoard[2][1] = ChineseChessPieceEnum.RED_CANNON;
        chessBoard[2][7] = ChineseChessPieceEnum.RED_CANNON;
        chessBoard[3][0] = ChineseChessPieceEnum.RED_PAWN;
        chessBoard[3][2] = ChineseChessPieceEnum.RED_PAWN;
        chessBoard[3][4] = ChineseChessPieceEnum.RED_PAWN;
        chessBoard[3][6] = ChineseChessPieceEnum.RED_PAWN;
        chessBoard[3][8] = ChineseChessPieceEnum.RED_PAWN;

        chessBoard[9][0] = ChineseChessPieceEnum.GREEN_ROOK;
        chessBoard[9][1] = ChineseChessPieceEnum.GREEN_KNIGHT;
        chessBoard[9][2] = ChineseChessPieceEnum.GREEN_ELEPHANT;
        chessBoard[9][3] = ChineseChessPieceEnum.GREEN_MANDARIN;
        chessBoard[9][4] = ChineseChessPieceEnum.GREEN_KING;
        chessBoard[9][5] = ChineseChessPieceEnum.GREEN_MANDARIN;
        chessBoard[9][6] = ChineseChessPieceEnum.GREEN_ELEPHANT;
        chessBoard[9][7] = ChineseChessPieceEnum.GREEN_KNIGHT;
        chessBoard[9][8] = ChineseChessPieceEnum.GREEN_ROOK;
        chessBoard[7][1] = ChineseChessPieceEnum.GREEN_CANNON;
        chessBoard[7][7] = ChineseChessPieceEnum.GREEN_CANNON;
        chessBoard[6][0] = ChineseChessPieceEnum.GREEN_PAWN;
        chessBoard[6][2] = ChineseChessPieceEnum.GREEN_PAWN;
        chessBoard[6][4] = ChineseChessPieceEnum.GREEN_PAWN;
        chessBoard[6][6] = ChineseChessPieceEnum.GREEN_PAWN;
        chessBoard[6][8] = ChineseChessPieceEnum.GREEN_PAWN;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ChineseChessRoom) {
            ChineseChessRoom chineseChessRoom = (ChineseChessRoom) obj;
            return this.id == chineseChessRoom.id;
        }
        return false;
    }

    @Override
    public String toString() {
        return "中国象棋房间，房间id：" + this.id + "，房间名：" + this.name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ChineseChessRoomStateEnum getState() {
        return state;
    }

    public void setState(ChineseChessRoomStateEnum state) {
        this.state = state;
    }

    public static long getDefaultId() {
        return DEFAULT_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChineseChessPieceEnum[][] getChessBoard() {
        return chessBoard;
    }

    public Queue<ChineseChessStep> getChessManual() {
        return chessManual;
    }

    public long getStepTime() {
        return stepTime;
    }

    public void setStepTime(long stepTime) {
        this.stepTime = stepTime;
    }

    public long getRoomTime() {
        return roomTime;
    }

    public void setRoomTime(long roomTime) {
        this.roomTime = roomTime;
    }
}
