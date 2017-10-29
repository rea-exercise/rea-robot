package com.codeexercise.robot;

/**
 * Direction is used to denote the direction that the robot is facing
 *
 */
public enum Direction {

    NORTH(0, "NORTH"),
    EAST(1, "EAST"),
    SOUTH(2, "SOUTH"),
    WEST(3, "WEST");

    private final int value;
    private final String name;

    private Direction(final int newValue, String newName) {
        value = newValue;
        name = newName;
    }

    /**
     * @return The Integer value represent the Direction
     */
    public int getValue() {
        return value;
    }

    /**
     * Name of the direction
     *
     * @return the name of the direction
     */
    public String getName() {
        return name;
    }

}