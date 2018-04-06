package com.siby.assignments.db.rover;

import java.util.Collections;
import java.util.List;

public class Rover {

    private Coordinate location;
    private Direction face;
    private List<Coordinate> obstacles;

    private Rover(Coordinate location, Direction face, List<Coordinate> obstacles) {
        this.location = location;
        this.face = face;
        this.obstacles = obstacles;
    }

    public Coordinate getLocation() {
        return location;
    }

    public Direction getFace() {
        return face;
    }

    public void commands(Command[] commands) {
        for (Command command : commands) {
            switch (command) {
                case FORWARD:
                case BACKWARD:
                    move(command);
                    continue;
                default:
                    turn(command);
            }
        }
    }

    void move(Command command) {

        int xDelta = 0;
        int yDelta = 0;

        switch (face) {
            case EAST:
                xDelta = 1;
                break;
            case WEST:
                xDelta = -1;
                break;
            case NORTH:
                yDelta = 1;
                break;
            case SOUTH:
                yDelta = -1;
                break;
        }

        if (command == Command.BACKWARD) {
            xDelta *= -1;
            yDelta *= -1;
        }

        Coordinate nextLocation = Coordinate.instance(getLocation().getX() + xDelta, getLocation().getY() + yDelta);

        if (!hasObstacle(nextLocation)) {
            location = nextLocation;
        }
    }

    void turn(Command command) {

        if (command == Command.LEFT) { // Left
            switch (face) {
                case EAST:
                    face = Direction.NORTH;
                    break;
                case WEST:
                    face = Direction.SOUTH;
                    break;
                case NORTH:
                    face = Direction.WEST;
                    break;
                case SOUTH:
                    face = Direction.EAST;
                    break;
            }
        } else { // Right
            switch (face) {
                case EAST:
                    face = Direction.SOUTH;
                    break;
                case WEST:
                    face = Direction.NORTH;
                    break;
                case NORTH:
                    face = Direction.EAST;
                    break;
                case SOUTH:
                    face = Direction.WEST;
                    break;
            }
        }
    }

    private boolean hasObstacle(Coordinate coordinate) {
        for (Coordinate obstacle : obstacles) {
            if (obstacle.getX() == coordinate.getX() && obstacle.getY() == coordinate.getY()) {
                return true;
            }
        }
        return false;
    }


    public static class Builder {
        private Coordinate location = Coordinate.instance(0, 0);
        private Direction face = Direction.NORTH;
        private List<Coordinate> obstacles = Collections.emptyList();

        public Builder location(Coordinate location) {
            this.location = location;
            return this;
        }

        public Builder face(Direction face) {
            this.face = face;
            return this;
        }

        public Builder obstacles(final List<Coordinate> obstacles) {
            this.obstacles = obstacles;
            return this;
        }

        public Rover build() {
            return new Rover(location, face, obstacles);
        }
    }
}
