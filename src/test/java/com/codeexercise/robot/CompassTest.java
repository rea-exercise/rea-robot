package com.codeexercise.robot;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Test SimpleCompass implementation
 */
public class CompassTest {

    @Test
    public final void whenRotate90DegreeToTheLeftFromNorthThenItShouldBeFacingWest() {

        Direction direction = Compass.rotate90DegreeLeft(Direction.NORTH);
        assertTrue("When rotate 90 degree to the left from NORTH. It should be facing WEST.",direction == Direction.WEST);
    }

    @Test
    public final void whenRotate90DegreeToTheLeftFromWestThenItShouldBeFacingSouth() {

        Direction direction = Compass.rotate90DegreeLeft(Direction.WEST);
        assertTrue("When rotate 90 degree to the left from WEST. It should be facing SOUTH.",direction == Direction.SOUTH);
    }

    @Test
    public final void whenRotate90DegreeToTheLeftFromSouthThenItShouldBeFacingEast() {

        Direction direction = Compass.rotate90DegreeLeft(Direction.SOUTH);
        assertTrue("When rotate 90 degree to the left from SOUTH. It should be facing EAST.",direction == Direction.EAST);
    }

    @Test
    public final void whenRotate90DegreeToTheLeftFromEastThenItShouldBeFacingNorth() {

        Direction direction = Compass.rotate90DegreeLeft(Direction.EAST);
        assertTrue("When rotate 90 degree to the left from EAST. It should be facing EAST.",direction == Direction.NORTH);
    }

    @Test
    public final void whenRotate90DegreeToTheRightFromNorthThenItShouldBeFacingEast() {

        Direction direction = Compass.rotate90DegreeRight(Direction.NORTH);
        assertTrue("When rotate 90 degree to the right from NORTH. It should be facing EAST.",direction == Direction.EAST);
    }

    @Test
    public final void whenRotate90DegreeToTheRightFromEastThenItShouldBeFacingSouth() {

        Direction direction = Compass.rotate90DegreeRight(Direction.EAST);
        assertTrue("When rotate 90 degree to the right from EAST. It should be facing SOUTH.",direction == Direction.SOUTH);
    }

    @Test
    public final void whenRotate90DegreeToTheRightFromSouthThenItShouldBeFacingWest() {

        Direction direction = Compass.rotate90DegreeRight(Direction.SOUTH);
        assertTrue("When rotate 90 degree to the right from SOUTH. It should be facing WEST.",direction == Direction.WEST);
    }

    @Test
    public final void whenRotate90DegreeToTheRightFromWestThenItShouldBeFacingNorth() {

        Direction direction = Compass.rotate90DegreeRight(Direction.WEST);
        assertTrue("When rotate 90 degree to the right from WEST. It should be facing NORTH.",direction == Direction.NORTH);
    }
}
