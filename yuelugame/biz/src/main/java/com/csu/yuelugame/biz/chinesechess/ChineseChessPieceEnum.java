package com.csu.yuelugame.biz.chinesechess;

public enum ChineseChessPieceEnum {

    RED_ROOK(ChineseChessPieceColorEnum.RED, "车"),
    RED_KNIGHT(ChineseChessPieceColorEnum.RED, "马"),
    RED_ELEPHANT(ChineseChessPieceColorEnum.RED, "相"),
    RED_MANDARIN(ChineseChessPieceColorEnum.RED, "士"),
    RED_KING(ChineseChessPieceColorEnum.RED, "帅"),
    RED_CANNON(ChineseChessPieceColorEnum.RED, "炮"),
    RED_PAWN(ChineseChessPieceColorEnum.RED, "兵"),
    GREEN_ROOK(ChineseChessPieceColorEnum.GREEN, "车"),
    GREEN_KNIGHT(ChineseChessPieceColorEnum.GREEN, "马"),
    GREEN_ELEPHANT(ChineseChessPieceColorEnum.GREEN, "象"),
    GREEN_MANDARIN(ChineseChessPieceColorEnum.GREEN, "仕"),
    GREEN_KING(ChineseChessPieceColorEnum.GREEN, "将"),
    GREEN_CANNON(ChineseChessPieceColorEnum.GREEN, "炮"),
    GREEN_PAWN(ChineseChessPieceColorEnum.GREEN, "卒");

    private String type;//棋子类属
    private ChineseChessPieceColorEnum color;//棋子颜色

    ChineseChessPieceEnum(ChineseChessPieceColorEnum color, String type) {
        this.color = color;
        this.type = type;
    }

    public ChineseChessPieceColorEnum getColor() {
        return color;
    }

    public void setColor(ChineseChessPieceColorEnum color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return this.color + this.type;
    }
}
