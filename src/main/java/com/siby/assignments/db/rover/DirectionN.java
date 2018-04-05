package com.siby.assignments.db.rover;


public enum DirectionN {

    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W');

    private char shortName;

    DirectionN(char shortNameValue) {
        shortName = shortNameValue;
    }

    public char getShortName() {
        return shortName;
    }

}