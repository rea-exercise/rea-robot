package com.codeexercise.robot;

import java.util.ArrayList;

public class Compass {


    private static int MAX_DIRECTION_ELEMENTS = 3;

    private static final ArrayList<Direction> compass = new ArrayList<Direction>() {
        {
            add(Direction.NORTH);
            add(Direction.EAST);
            add(Direction.SOUTH);
            add(Direction.WEST);
        }
    };

    /**
     * Rotate the object 90 degrees in the left direction
     * @param direction The current object direction
     * @return The new Direction
     */
    public static Direction rotate90DegreeLeft(Direction direction) {
        if (direction.getValue() == 0) {
            return compass.get(MAX_DIRECTION_ELEMENTS);
        } else {
            return compass.get(direction.getValue() - 1);
        }
    }

    /**
     * Rotate the object 90 degrees in the right direction
     * @param direction the current object direction
     * @return The new Direction
     */
    public static Direction rotate90DegreeRight(Direction direction) {
        if (direction.getValue() == MAX_DIRECTION_ELEMENTS) {
            return compass.get(0);
        } else {
            return compass.get(direction.getValue() + 1);
        }
    }
}
