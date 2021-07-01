package com.csu.yuelugame.biz.chinesechess;

public class ChineseChessStep {

    private ChineseChessPieceEnum startPiece;
    private ChineseChessPieceEnum endPiece;
    private Coord startPoint;
    private Coord endPoint;

    public ChineseChessStep() {
        this.startPiece = null;
        this.endPiece = null;
        this.startPoint = new Coord();
        this.endPoint = new Coord();

    }

    public ChineseChessPieceEnum getStartPiece() {
        return startPiece;
    }

    public void setStartPiece(ChineseChessPieceEnum startPiece) {
        this.startPiece = startPiece;
    }

    public ChineseChessPieceEnum getEndPiece() {
        return endPiece;
    }

    public void setEndPiece(ChineseChessPieceEnum endPiece) {
        this.endPiece = endPiece;
    }

    public Coord getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Coord startPoint) {
        this.startPoint = startPoint;
    }

    public Coord getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Coord endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public String toString() {
        if (this.endPiece == null) {
            return this.startPiece.toString() + this.startPoint + " move " + this.endPoint.toString();
        } else {
            return this.startPiece.toString() + this.startPoint + " eat " + this.endPiece.toString() + this.endPoint.toString();
        }
    }
}
