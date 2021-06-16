package com.csu.yuelugame.biz.response;

public class ChineseChessRoomCantCreateResponse {
    private boolean result;
    private String message;
    public ChineseChessRoomCantCreateResponse(){
        this.result=false;
        this.message="Name Repeat!";
    }
    public boolean isF() {
        return result;
    }

    public void setF(boolean f) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
