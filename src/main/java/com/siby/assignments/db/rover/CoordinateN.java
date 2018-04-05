package com.siby.assignments.db.rover;

import java.util.Objects;

public class CoordinateN {
    private final int x;
    private final int y;

    private CoordinateN(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static CoordinateN instance(int x, int y) {
        return new CoordinateN(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoordinateN)) return false;
        CoordinateN that = (CoordinateN) o;
        return getX() == that.getX() &&
                getY() == that.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CoordinateN{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }
}
