package com.liugs.algorithm.pedigree;

/**
 * @author liugs
 * @createTime 2022/2/10 15:29
 */
public class Point {
    private String id;
    private int x;
    private int y;

    public Point(String id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public void offset(int xOffset,int yOffset){
        x += xOffset;
        y += yOffset;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
