package com.siby.assignments.db.rover;

public class RoverN {

    private CoordinateN location;
    private DirectionN face;

    private RoverN(CoordinateN location, DirectionN face) {
        this.location = location;
        this.face = face;
    }

    public CoordinateN getLocation() {
        return location;
    }

    public void setLocation(CoordinateN location) {
        this.location = location;
    }

    public DirectionN getFace() {
        return face;
    }

    public void setFace(DirectionN face) {
        this.face = face;
    }

    public void commands(CommandN[] commands) {

    }

    void move(CommandN command) {

        int xDelta = 0, yDelta = 0;

        switch (face) {
            case EAST:
                xDelta = 1;
                break;
            case WEST:
                xDelta = -1;
                break;
            case NORTH:
                yDelta = -1;
                break;
            case SOUTH:
                yDelta = 1;
                break;
        }

        if (command == CommandN.BACKWARD) {
            xDelta *= -1;
            yDelta *= -1;
        }

        setLocation(CoordinateN.instance(getLocation().getX() + xDelta, getLocation().getY() + yDelta));
    }

    void turn(CommandN command) {

        if (command == CommandN.LEFT) { // Left
            switch (face) {
                case EAST:
                    face = DirectionN.NORTH;
                    break;
                case WEST:
                    face = DirectionN.SOUTH;
                    break;
                case NORTH:
                    face = DirectionN.WEST;
                    break;
                case SOUTH:
                    face = DirectionN.EAST;
                    break;
            }
        } else { // Right
            switch (face) {
                case EAST:
                    face = DirectionN.SOUTH;
                    break;
                case WEST:
                    face = DirectionN.NORTH;
                    break;
                case NORTH:
                    face = DirectionN.EAST;
                    break;
                case SOUTH:
                    face = DirectionN.WEST;
                    break;
            }
        }

    }

    public static class Builder {
        private CoordinateN location = CoordinateN.instance(0, 0);
        private DirectionN face = DirectionN.NORTH;

        public Builder location(CoordinateN location) {
            this.location = location;
            return this;
        }

        public Builder face(DirectionN face) {
            this.face = face;
            return this;
        }

        public RoverN build() {
            return new RoverN(location, face);
        }
    }
}
