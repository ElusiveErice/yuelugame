package com.csu.yuelugame.biz.beans.chinesechess;

import java.util.List;

public class ChineseChessRoomSingleton {
    private volatile static ChineseChessRoomSingleton chineseChessRoomSingleton;
    private ChineseChessRoomSingleton(){}
    public static ChineseChessRoomSingleton getSingleton(){
        if(chineseChessRoomSingleton ==null){
            synchronized (ChineseChessRoomSingleton.class){
                if(chineseChessRoomSingleton ==null){
                    chineseChessRoomSingleton=new ChineseChessRoomSingleton();
                }
            }
        }
        return chineseChessRoomSingleton;
    }

    private List<ChineseChessRoom> roomList;

    public List<ChineseChessRoom> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<ChineseChessRoom> roomList) {
        this.roomList = roomList;
    }
}
