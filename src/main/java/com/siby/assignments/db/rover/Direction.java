package com.siby.assignments.db.rover;


public enum Direction {

    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W');

    private char shortName;

    Direction(char shortNameValue) {
        shortName = shortNameValue;
    }

    public char getShortName() {
        return shortName;
    }

}