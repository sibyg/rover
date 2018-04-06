package com.siby.assignments.db.rover;


public enum Command {

    FORWARD('F'),
    BACKWARD('B'),
    LEFT('L'),
    RIGHT('R');

    private char shortName;

    Command(char shortNameValue) {
        shortName = shortNameValue;
    }

    public char getShortName() {
        return shortName;
    }

}