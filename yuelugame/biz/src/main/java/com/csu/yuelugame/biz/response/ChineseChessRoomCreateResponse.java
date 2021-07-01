package com.csu.yuelugame.biz.response;

import com.csu.yuelugame.biz.chinesechess.ChineseChessRoom;

public class ChineseChessRoomCreateResponse {

    private boolean result;
    private ChineseChessRoom cr;
    public ChineseChessRoomCreateResponse(ChineseChessRoom cr){
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
