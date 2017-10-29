package com.codeexercise.robot.impl;

import com.codeexercise.robot.Location;
import com.codeexercise.robot.Table;
import com.codeexercise.robot.util.ValidateUtils;

/**
 * The SquareTable implementation
 *
 */
public class SquareTable implements Table {


    private final int size;


    /**
     * Create Square table with dimension. e.g size = 4 will make the 4 x 4 table
     *
     * @param size
     *            the table size
     */
    public SquareTable(int size) {
        ValidateUtils.isTrue(size > 0, "Table size cannot be negative.");
        this.size = size;
    }

    public boolean isOnTable(Location location) {

        boolean onX = location.getX() >= 0 && location.getX() <= this.size;
        boolean onY = location.getY() >= 0 && location.getY() <= this.size;
        return onX && onY;
    }
}
