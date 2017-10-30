package com.codeexercise.robot;

/**
 * Table to place item on.
 *
 */
public interface Table {

    /**
     * Check if given point can be on the table
     * @param location The location <code> Location </code> to check.
     * @return true if point is on the table; false otherwise.
     */
    boolean isOnTable(Location location);

}
