package com.codeexercise.robot;

import com.codeexercise.robot.exception.RobotOutsideTableException;
import com.codeexercise.robot.impl.SquareTable;
import com.codeexercise.robot.impl.ToyRobot;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test of ToyRobot's implementation.
 */
public class ToyRobotTest {

    private Robot robot;
    private Table table;

    @Before
    public void before() throws Exception {
        robot = new ToyRobot();
        table = new SquareTable(4);

    }


    @Test(expected = NullPointerException.class)
    public final void whenPlaceRobotIfPointIsNullThenExceptionIsThrown() throws RobotOutsideTableException {
        Direction d = Direction.NORTH;
        robot.place(null, d, table);
    }

    @Test(expected = NullPointerException.class)
    public final void whenPlaceRobotIfDirectionIsNullThenExceptionIsThrown() throws RobotOutsideTableException {
        robot.place(new Location(0, 0), null,table);
    }

    @Test(expected = NullPointerException.class)
    public final void whenPlaceRobotIfTableIsNullThenExceptionIsThrown() throws RobotOutsideTableException {
        Direction d = Direction.NORTH;
        robot.place(new Location(0, 0), d, null);
    }

    @Test
    public final void whenAllParametersAreNotNullThenNoExceptionIsThrown() throws RobotOutsideTableException {
        Direction d = Direction.NORTH;
        robot.place(new Location(0, 0), d, table);
    }

    @Test
    public final void whenPlaceRobotOnTheTableThenReturnTrue() throws RobotOutsideTableException {

        Location point = new Location(1, 1);
        robot.place(point, Direction.NORTH, table);
        assertTrue("Robot has not been placed on table", robot.isPlacedOnTable());
    }

    @Test
    public final void whenRobotHasNotBeenPlacedOnTheTableThenReturnFalse() {

        assertFalse("Robot has been placed on table", robot.isPlacedOnTable());
    }


    @Test
    public final void whenPlaceRobotOnThePointInsideTableThenPointShouldBeAssigned() throws RobotOutsideTableException {
        Location location = new Location(0, 0);
        robot.place(location, Direction.NORTH, table);

        assertNotNull("Location should be assigned to the robot", robot.getLocation());
        assertEquals("Robot was place in different Location on table", location, robot.getLocation());
    }

    @Test(expected = RobotOutsideTableException.class)
    public final void whenPlaceRobotOutsideTableThenExceptionIsThrown() throws RobotOutsideTableException {
        Location point = new Location(5, 1);
        robot.place(point, Direction.NORTH, table);

    }

    @Test
    public final void whenRobotHasNotBeenPlacedOnTableThenDoNothingWhenMove() {
        robot.move();
        robot.turnLeft();
        robot.turnRight();
        assertNull("Point should be null", robot.getLocation());
        assertNull("Direction should be null", robot.getDirection());

    }

    @Test
    public final void whenRobotIsOnTheEdgeThenItShouldNotMove() throws RobotOutsideTableException {

        Location location = new Location(0, 0);
        robot.place(location, Direction.SOUTH, table);
        robot.move();
        assertEquals("Robot is falling off the table", location, robot.getLocation());

        location = new Location(4, 0);
        robot.place(location, Direction.EAST, table);
        robot.move();
        assertEquals("Robot is falling off the table", location, robot.getLocation());

        location = new Location(4, 4);
        robot.place(location, Direction.NORTH, table);
        robot.move();
        assertEquals("Robot is falling off the table", location, robot.getLocation());

        location = new Location(0, 4);
        robot.place(location, Direction.WEST, table);
        robot.move();
        assertEquals("Robot is falling off the table", location, robot.getLocation());
    }

    @Test
    public final void whenMoveRobotThenItShouldMoveToTheProperPoint() throws RobotOutsideTableException {

        Location location = new Location(1, 1);

        // Facing NORTH
        robot.place(location, Direction.NORTH, table);
        robot.move();
        assertNotEquals("Robot doesn't move. Point are the same. Facing NORTH", location, robot.getLocation());
        assertEquals("Robot didn't move on proper coordinate!. Facing NORTH", location.getX(), robot.getLocation().getX());
        assertEquals("Robot didn't move on proper coordinate!. Facing NORTH", location.getY() + 1, robot.getLocation().getY());

        // Facing WEST
        robot.place(location, Direction.WEST, table);
        robot.move();
        assertNotEquals("Robot doesn't move. Point are the same. Facing WEST", location, robot.getLocation());
        assertEquals("Robot didn't move on proper coordinate!. Facing WEST", location.getX() - 1, robot.getLocation().getX());
        assertEquals("Robot didn't move on proper coordinate!. Facing WEST", location.getY(), robot.getLocation().getY());

        // Facing SOUTH
        robot.place(location, Direction.SOUTH, table);
        robot.move();
        assertNotEquals("Robot doesn't move. Point are the same. Facing SOUTH", location, robot.getLocation());
        assertEquals("Robot didn't move on proper coordinate!. Facing SOUTH", location.getX(), robot.getLocation().getX());
        assertEquals("Robot didn't move on proper coordinate!. Facing SOUTH", location.getY() - 1, robot.getLocation().getY());

        // Facing EAST
        robot.place(location, Direction.EAST, table);
        robot.move();
        assertNotEquals("Robot doesn't move. Point are the same. Facing EAST", location, robot.getLocation());
        assertEquals("Robot didn't move on proper coordinate!. Facing EAST", location.getX() + 1, robot.getLocation().getX());
        assertEquals("Robot didn't move on proper coordinate!. Facing EAST", location.getY(), robot.getLocation().getY());

    }

    @Test
    public final void whenMoveRobotThenItShouldMoveForwardInTheDirection() throws RobotOutsideTableException {
        Location location = new Location(1, 1);
        Direction direction = null;

        // Facing NORTH
        direction = Direction.NORTH;
        robot.place(location, direction, table);
        robot.move();
        assertEquals("Robot direction should not be changed when move.", direction, robot.getDirection());

        // Facing WEST
        direction = Direction.WEST;
        robot.place(location, direction, table);
        robot.move();
        assertEquals("Robot direction should not be changed when move.", direction, robot.getDirection());

        // Facing SOUTH
        direction = Direction.SOUTH;
        robot.place(location, direction, table);
        robot.move();
        assertEquals("Robot direction should not be changed when move.", direction, robot.getDirection());

        // Facing EAST
        direction = Direction.EAST;
        robot.place(location, direction, table);
        robot.move();
        assertEquals("Robot direction should not be changed when move.", direction, robot.getDirection());
    }

    @Test
    public final void whenTurnLeftTheRobotShouldRotate90DegreesToTheLeft() throws RobotOutsideTableException {
        Location location = new Location(1, 1);

        // Facing NORTH
        robot.place(location, Direction.NORTH, table);
        robot.turnLeft();
        assertEquals("Robot should be facing WEST.", Direction.WEST, robot.getDirection());
        robot.turnLeft();
        assertEquals("Robot should be facing SOUTH.", Direction.SOUTH, robot.getDirection());
        robot.turnLeft();
        assertEquals("Robot should be facing EAST.", Direction.EAST, robot.getDirection());
        robot.turnLeft();
        assertEquals("Robot should be facing NORTH.", Direction.NORTH, robot.getDirection());
    }

    @Test
    public final void whenTurnRightTheRobotShouldRotate90DegreesToTheRight() throws RobotOutsideTableException {
        Location location = new Location(1, 1);

        // Facing NORTH
        robot.place(location, Direction.NORTH, table);
        robot.turnRight();
        assertEquals("Robot should be facing EAST.", Direction.EAST, robot.getDirection());
        robot.turnRight();
        assertEquals("Robot should be facing SOUTH.", Direction.SOUTH, robot.getDirection());
        robot.turnRight();
        assertEquals("Robot should be facing WEST.", Direction.WEST, robot.getDirection());
        robot.turnRight();
        assertEquals("Robot should be facing NORTH.", Direction.NORTH, robot.getDirection());
    }



    @After
    public void after() throws Exception {
        table = null;
        robot = null;
    }
}
