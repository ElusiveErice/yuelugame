package com.csu.yuelugame.biz.response;

import com.csu.yuelugame.biz.beans.chinesechess.ChineseChessRoom;

public class ChineseChessRoomFindResponse {
    private boolean result;
    private ChineseChessRoom cr;
    public ChineseChessRoomFindResponse(ChineseChessRoom cr){
        this.cr=cr;
        this.result =true;
    }
    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public ChineseChessRoom getCr() {
        return cr;
    }

    public void setCr(ChineseChessRoom cr) {
        this.cr = cr;
    }
}
