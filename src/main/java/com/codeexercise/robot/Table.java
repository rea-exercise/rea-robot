package com.codeexercise.robot;

/**
 * Table to place item on.
 *
 */
public interface Table {

    /**
     * Check if given point can be on the table
     * @param location
     * @return true if point is on the table; false otherwise.
     */
    boolean isOnTable(Location location);

}