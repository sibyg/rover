package com.siby.assignments.db.rover;

import static com.siby.assignments.db.rover.Command.FORWARD;
import static com.siby.assignments.db.rover.Command.LEFT;
import static com.siby.assignments.db.rover.Direction.NORTH;
import static com.siby.assignments.db.rover.Direction.SOUTH;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;

import org.junit.Test;


public class RoverTest {

    @Test
    public void shouldSetStartingLocation() {
        // given
        Coordinate location = Coordinate.instance(10, 12);

        // when
        Rover rover = new Rover.Builder()
                .location(location)
                .build();

        // then
        assertThat(rover.getLocation()).isEqualTo(location);
    }

    @Test
    public void shouldSetDefaultStartingLocation() {
        // when
        Rover rover = new Rover.Builder()
                .build();

        // then
        assertThat(rover.getLocation()).isEqualTo(Coordinate.instance(0, 0));
    }

    @Test
    public void shouldSetFace() {
        // given
        Direction face = Direction.EAST;

        // when
        Rover rover = new Rover.Builder()
                .face(face)
                .build();

        // then
        assertThat(rover.getFace()).isEqualTo(face);
    }

    @Test
    public void shouldSetDefaultFace() {
        // when
        Rover rover = new Rover.Builder()
                .build();

        // then
        assertThat(rover.getFace()).isEqualTo(NORTH);
    }


    @Test
    public void shouldIncreaseXWhenMovingForwardWhileFacingEast() {
        // given
        Coordinate location = Coordinate.instance(10, 12);
        // and
        Direction face = Direction.EAST;
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .build();

        // when
        rover.move(FORWARD);

        // then
        assertThat(rover.getLocation()).isEqualTo(Coordinate.instance(11, 12));
    }

    @Test
    public void shouldReduceXWhenMovingForwardWhileFacingWest() {
        // given
        Coordinate location = Coordinate.instance(10, 12);
        // and
        Direction face = Direction.WEST;
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .build();

        // when
        rover.move(FORWARD);

        // then
        assertThat(rover.getLocation()).isEqualTo(Coordinate.instance(9, 12));
    }

    @Test
    public void shouldIncreaseYWhenMovingForwardWhileFacingNorth() {
        // given
        Coordinate location = Coordinate.instance(10, 12);
        // and
        Direction face = NORTH;
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .build();

        // when
        rover.move(FORWARD);

        // then
        assertThat(rover.getLocation()).isEqualTo(Coordinate.instance(10, 13));
    }

    @Test
    public void shouldReduceYWhenMovingForwardWhileFacingSouth() {
        // given
        Coordinate location = Coordinate.instance(10, 12);
        // and
        Direction face = Direction.SOUTH;
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .build();

        // when
        rover.move(FORWARD);

        // then
        assertThat(rover.getLocation()).isEqualTo(Coordinate.instance(10, 11));
    }

    @Test
    public void shouldReduceXWhenMovingBackwardWhileFacingEast() {
        // given
        Coordinate location = Coordinate.instance(10, 12);
        // and
        Direction face = Direction.EAST;
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .build();

        // when
        rover.move(Command.BACKWARD);

        // then
        assertThat(rover.getLocation()).isEqualTo(Coordinate.instance(9, 12));
    }

    @Test
    public void shouldIncreaseXWhenMovingBackwardWhileFacingWest() {
        // given
        Coordinate location = Coordinate.instance(10, 12);
        // and
        Direction face = Direction.WEST;
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .build();

        // when
        rover.move(Command.BACKWARD);

        // then
        assertThat(rover.getLocation()).isEqualTo(Coordinate.instance(11, 12));
    }

    @Test
    public void shouldDecreaseYWhenMovingBackwardWhileFacingNorth() {
        // given
        Coordinate location = Coordinate.instance(10, 12);
        // and
        Direction face = NORTH;
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .build();

        // when
        rover.move(Command.BACKWARD);

        // then
        assertThat(rover.getLocation()).isEqualTo(Coordinate.instance(10, 11));
    }

    @Test
    public void shouldIncreaseYWhenMovingBackwardWhileFacingSouth() {
        // given
        Coordinate location = Coordinate.instance(10, 12);
        // and
        Direction face = Direction.SOUTH;
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .build();

        // when
        rover.move(Command.BACKWARD);

        // then
        assertThat(rover.getLocation()).isEqualTo(Coordinate.instance(10, 13));
    }

    @Test
    public void shouldChangeFromEastToNorthOnLeftTurn() {
        // given
        Coordinate location = Coordinate.instance(10, 12);
        // and
        Direction face = Direction.EAST;
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .build();

        // when
        rover.turn(LEFT);

        // then
        assertThat(rover.getFace()).isEqualTo(NORTH);
    }

    @Test
    public void shouldChangeFromNorthToWestOnLeftTurn() {
        // given
        Coordinate location = Coordinate.instance(10, 12);
        // and
        Direction face = NORTH;
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .build();

        // when
        rover.turn(LEFT);

        // then
        assertThat(rover.getFace()).isEqualTo(Direction.WEST);
    }

    @Test
    public void shouldChangeFromWestToSouthOnLeftTurn() {
        // given
        Coordinate location = Coordinate.instance(10, 12);
        // and
        Direction face = Direction.WEST;
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .build();

        // when
        rover.turn(LEFT);

        // then
        assertThat(rover.getFace()).isEqualTo(Direction.SOUTH);
    }

    @Test
    public void shouldChangeFromSouthToEastOnLeftTurn() {
        // given
        Coordinate location = Coordinate.instance(10, 12);
        // and
        Direction face = Direction.SOUTH;
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .build();

        // when
        rover.turn(LEFT);

        // then
        assertThat(rover.getFace()).isEqualTo(Direction.EAST);
    }

    @Test
    public void shouldChangeFromEastToSouthOnRightTurn() {
        // given
        Coordinate location = Coordinate.instance(10, 12);
        // and
        Direction face = Direction.EAST;
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .build();

        // when
        rover.turn(Command.RIGHT);

        // then
        assertThat(rover.getFace()).isEqualTo(Direction.SOUTH);
    }

    @Test
    public void shouldChangeFromSouthToWestOnRightTurn() {
        // given
        Coordinate location = Coordinate.instance(10, 12);
        // and
        Direction face = Direction.SOUTH;
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .build();

        // when
        rover.turn(Command.RIGHT);

        // then
        assertThat(rover.getFace()).isEqualTo(Direction.WEST);
    }

    @Test
    public void shouldChangeFromWestToNorthOnRightTurn() {
        // given
        Coordinate location = Coordinate.instance(10, 12);
        // and
        Direction face = Direction.WEST;
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .build();

        // when
        rover.turn(Command.RIGHT);

        // then
        assertThat(rover.getFace()).isEqualTo(NORTH);
    }

    @Test
    public void shouldChangeFromNorthToEastOnRightTurn() {
        // given
        Coordinate location = Coordinate.instance(10, 12);
        // and
        Direction face = NORTH;
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .build();

        // when
        rover.turn(Command.RIGHT);

        // then
        assertThat(rover.getFace()).isEqualTo(Direction.EAST);
    }

    @Test
    public void shouldNotMoveForwardEastWhenObstacleFound() {
        // given
        Coordinate location = Coordinate.instance(10, 12);
        // and
        Direction face = Direction.EAST;
        // and
        List<Coordinate> obstacles = Collections.singletonList(Coordinate.instance(location.getX() + 1, location.getY()));
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .obstacles(obstacles)
                .build();

        // when
        rover.move(FORWARD);

        // then
        assertThat(rover.getLocation()).isEqualTo(location);
    }

    @Test
    public void shouldNotMoveForwardWestWhenObstacleFound() {
        // given
        Coordinate location = Coordinate.instance(10, 12);
        // and
        Direction face = Direction.WEST;
        // and
        List<Coordinate> obstacles = Collections.singletonList(Coordinate.instance(location.getX() - 1, location.getY()));
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .obstacles(obstacles)
                .build();

        // when
        rover.move(FORWARD);

        // then
        assertThat(rover.getLocation()).isEqualTo(location);
    }

    @Test
    public void shouldNotMoveForwardNorthWhenObstacleFound() {
        // given
        Coordinate location = Coordinate.instance(10, 12);
        // and
        Direction face = NORTH;
        // and
        List<Coordinate> obstacles = Collections.singletonList(Coordinate.instance(location.getX(), location.getY() + 1));
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .obstacles(obstacles)
                .build();

        // when
        rover.move(FORWARD);

        // then
        assertThat(rover.getLocation()).isEqualTo(location);
    }

    @Test
    public void shouldNotMoveForwardSouthWhenObstacleFound() {
        // given
        Coordinate location = Coordinate.instance(10, 12);
        // and
        Direction face = Direction.SOUTH;
        // and
        List<Coordinate> obstacles = Collections.singletonList(Coordinate.instance(location.getX(), location.getY() - 1));
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .obstacles(obstacles)
                .build();

        // when
        rover.move(FORWARD);

        // then
        assertThat(rover.getLocation()).isEqualTo(location);
    }

    @Test
    public void shouldNotMoveBackwardEastWhenObstacleFound() {
        // given
        Coordinate location = Coordinate.instance(10, 12);
        // and
        Direction face = Direction.EAST;
        // and
        List<Coordinate> obstacles = Collections.singletonList(Coordinate.instance(location.getX() - 1, location.getY()));
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .obstacles(obstacles)
                .build();

        // when
        rover.move(Command.BACKWARD);

        // then
        assertThat(rover.getLocation()).isEqualTo(location);
    }

    @Test
    public void shouldNotMoveBackwardWestWhenObstacleFound() {
        // given
        Coordinate location = Coordinate.instance(10, 12);
        // and
        Direction face = Direction.WEST;
        // and
        List<Coordinate> obstacles = Collections.singletonList(Coordinate.instance(location.getX() + 1, location.getY()));
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .obstacles(obstacles)
                .build();

        // when
        rover.move(Command.BACKWARD);

        // then
        assertThat(rover.getLocation()).isEqualTo(location);
    }

    @Test
    public void shouldNotMoveBackwardNorthWhenObstacleFound() {
        // given
        Coordinate location = Coordinate.instance(10, 12);
        // and
        Direction face = NORTH;
        // and
        List<Coordinate> obstacles = Collections.singletonList(Coordinate.instance(location.getX(), location.getY() - 1));
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .obstacles(obstacles)
                .build();

        // when
        rover.move(Command.BACKWARD);

        // then
        assertThat(rover.getLocation()).isEqualTo(location);
    }

    @Test
    public void shouldNotMoveBackwardSouthWhenObstacleFound() {
        // given
        Coordinate location = Coordinate.instance(10, 12);
        // and
        Direction face = Direction.SOUTH;
        // and
        List<Coordinate> obstacles = Collections.singletonList(Coordinate.instance(location.getX(), location.getY() + 1));
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .obstacles(obstacles)
                .build();

        // when
        rover.move(Command.BACKWARD);

        // then
        assertThat(rover.getLocation()).isEqualTo(location);
    }

    @Test
    public void shouldTakeCommands() {
        // given
        Coordinate location = Coordinate.instance(1, 2);
        // and
        Direction face = NORTH;
        // and
        Rover rover = new Rover.Builder()
                .location(location)
                .face(face)
                .build();

        // when
        rover.commands(new Command[]{LEFT, FORWARD, LEFT, FORWARD});

        // then
        assertThat(rover.getLocation()).isEqualTo(Coordinate.instance(0, 1));
        // and
        assertThat(rover.getFace()).isEqualTo(SOUTH);
    }
}