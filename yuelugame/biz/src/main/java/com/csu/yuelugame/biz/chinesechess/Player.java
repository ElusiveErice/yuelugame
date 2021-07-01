package com.csu.yuelugame.biz.chinesechess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

public class Player {

    public static final long MIN_SURPLUS_TIME = 0;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private long userId;
    private long surplusStepTime;
    private long surplusRoomTime;
    private boolean ready;//是否准备
    private ChineseChessPieceColorEnum color;//是否先行

    public Player(long userId) {
        this(userId, MIN_SURPLUS_TIME, MIN_SURPLUS_TIME);
    }

    public Player(long userId, long surplusStepTime, long surplusRoomTime) {
        this.userId = userId;
        this.surplusStepTime = surplusStepTime;
        this.surplusRoomTime = surplusRoomTime;
        this.ready = false;
        this.color = ChineseChessPieceColorEnum.GREEN;
    }

    public TimerTask makeTimerTask() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (surplusStepTime < MIN_SURPLUS_TIME || surplusRoomTime < MIN_SURPLUS_TIME) {
                    logger.info("用户" + userId + "超时了");
                } else {
                    surplusStepTime--;
                    surplusRoomTime--;
                }
            }
        };
        return timerTask;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getSurplusStepTime() {
        return surplusStepTime;
    }

    public void setSurplusStepTime(long surplusStepTime) {
        this.surplusStepTime = surplusStepTime;
    }

    public long getSurplusRoomTime() {
        return surplusRoomTime;
    }

    public void setSurplusRoomTime(long surplusRoomTime) {
        this.surplusRoomTime = surplusRoomTime;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public ChineseChessPieceColorEnum getColor() {
        return color;
    }

    public void setColor(ChineseChessPieceColorEnum color) {
        this.color = color;
    }
}
