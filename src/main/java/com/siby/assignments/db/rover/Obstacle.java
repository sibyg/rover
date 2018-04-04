package com.siby.assignments.db.rover;

public class Obstacle {

    private int x;
    private int y;

    public Obstacle(final int xValue, final int yValue) {
        setX(xValue);
        setY(yValue);
    }

    public int getX() {
        return x;
    }

    public void setX(final int value) {
        x = value;
    }

    public int getY() {
        return y;
    }

    public void setY(final int value) {
        y = value;
    }

}