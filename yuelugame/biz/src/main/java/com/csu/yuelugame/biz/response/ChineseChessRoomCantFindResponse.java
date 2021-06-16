package com.csu.yuelugame.biz.response;

public class ChineseChessRoomCantFindResponse {
    private boolean result;
    private String message;
    public ChineseChessRoomCantFindResponse(){
        this.result =false;
        this.message="Can not find Room";
    }
    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
