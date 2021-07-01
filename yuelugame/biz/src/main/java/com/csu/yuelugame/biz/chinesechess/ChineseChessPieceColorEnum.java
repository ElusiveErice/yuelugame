package com.csu.yuelugame.biz.chinesechess;

public enum ChineseChessPieceColorEnum {

    RED("红"), GREEN("绿");

    private String name;

    private ChineseChessPieceColorEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
