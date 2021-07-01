package com.csu.yuelugame.biz.chinesechess;

public class Coord {

    public static final int MIN_X = 0;
    public static final int MAX_X = 8;
    public static final int MIN_Y = 0;
    public static final int MAX_Y = 9;

    private int x;
    private int y;

    public Coord() {
        this(0, 0);
    }

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Coord) {
            Coord coord = (Coord) obj;
            return this.x == coord.x && this.y == coord.y;
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
