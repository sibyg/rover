package com.siby.assignments.db.rover;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;


public class RoverNTest {

    @Test
    public void shouldSetStartingLocation() {
        // given
        CoordinateN location = CoordinateN.instance(10, 12);

        // when
        RoverN roverN = new RoverN.Builder()
                .location(location)
                .build();

        // then
        assertThat(roverN.getLocation()).isEqualTo(location);
    }

    @Test
    public void shouldSetDefaultStartingLocation() {
        // when
        RoverN roverN = new RoverN.Builder()
                .build();

        // then
        assertThat(roverN.getLocation()).isEqualTo(CoordinateN.instance(0, 0));
    }

    @Test
    public void shouldSetFace() {
        // given
        DirectionN face = DirectionN.EAST;

        // when
        RoverN roverN = new RoverN.Builder()
                .face(face)
                .build();

        // then
        assertThat(roverN.getFace()).isEqualTo(face);
    }

    @Test
    public void shouldSetDefaultFace() {
        // when
        RoverN roverN = new RoverN.Builder()
                .build();

        // then
        assertThat(roverN.getFace()).isEqualTo(DirectionN.NORTH);
    }


    @Test
    public void shouldIncreaseXWhenMovingForwardWhileFacingEast() {
        // given
        CoordinateN location = CoordinateN.instance(10, 12);
        // and
        DirectionN face = DirectionN.EAST;
        // and
        RoverN roverN = new RoverN.Builder()
                .location(location)
                .face(face)
                .build();

        // when
        roverN.move(CommandN.FORWARD);

        // then
        assertThat(roverN.getLocation()).isEqualTo(CoordinateN.instance(11, 12));
    }

    @Test
    public void shouldReduceXWhenMovingForwardWhileFacingWest() {
        // given
        CoordinateN location = CoordinateN.instance(10, 12);
        // and
        DirectionN face = DirectionN.NORTH;
        // and
        RoverN roverN = new RoverN.Builder()
                .location(location)
                .face(face)
                .build();

        // when
        roverN.move(CommandN.FORWARD);

        // then
        assertThat(roverN.getLocation()).isEqualTo(CoordinateN.instance(9, 12));
    }

    @Test
    public void shouldIncreaseYWhenMovingForwardWhileFacingNorth() {
        // given
        CoordinateN location = CoordinateN.instance(10, 12);
        // and
        DirectionN face = DirectionN.NORTH;
        // and
        RoverN roverN = new RoverN.Builder()
                .location(location)
                .face(face)
                .build();

        // when
        roverN.move(CommandN.FORWARD);

        // then
        assertThat(roverN.getLocation()).isEqualTo(CoordinateN.instance(10, 13));
    }

    @Test
    public void shouldReduceYWhenMovingForwardWhileFacingSouth() {
        // given
        CoordinateN location = CoordinateN.instance(10, 12);
        // and
        DirectionN face = DirectionN.SOUTH;
        // and
        RoverN roverN = new RoverN.Builder()
                .location(location)
                .face(face)
                .build();

        // when
        roverN.move(CommandN.FORWARD);

        // then
        assertThat(roverN.getLocation()).isEqualTo(CoordinateN.instance(10, 11));
    }
}