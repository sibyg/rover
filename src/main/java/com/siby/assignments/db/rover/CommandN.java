package com.siby.assignments.db.rover;


public enum CommandN {

    FORWARD('F'),
    BACKWARD('B'),
    LEFT('L'),
    RIGHT('R');

    private char shortName;

    CommandN(char shortNameValue) {
        shortName = shortNameValue;
    }

    public char getShortName() {
        return shortName;
    }

}