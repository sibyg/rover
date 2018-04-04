package com.siby.assignments.db.rover;


class Point {

    private int location;
    private int maxLocation;

    Point(int locationValue, int maxLocationValue) {
        setLocation(locationValue);
        setMaxLocation(maxLocationValue);
    }

    int getLocation() {
        return location;
    }

    void setLocation(int value) {
        location = value;
    }

    int getMaxLocation() {
        return maxLocation;
    }

    private void setMaxLocation(int value) {
        maxLocation = value;
    }

    int getForwardLocation() {
        return (getLocation() + 1) % (getMaxLocation() + 1);
    }

    int getBackwardLocation() {
        if (getLocation() > 0) {
            return getLocation() - 1;
        } else return getMaxLocation();
    }

}