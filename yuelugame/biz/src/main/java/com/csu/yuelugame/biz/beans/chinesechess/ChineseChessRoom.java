package com.csu.yuelugame.biz.beans.chinesechess;

import com.csu.yuelugame.dao.beans.User;

import java.util.UUID;

public class ChineseChessRoom {

    private String id;
    private String name;
    private int playerCount;
    private boolean state;
    private User red;
    private User black;

    public ChineseChessRoom(){  //无参数，无用户
        this.id= UUID.randomUUID().toString();
        this.name=null;
        this.playerCount=0;
        this.state=true;
        this.red=null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    public User getRed() {
        return red;
    }

    public void setRed(User red) {
        this.red = red;
    }

    public User getBlack() {
        return black;
    }

    public void setBlack(User black) {
        this.black = black;
    }


}
