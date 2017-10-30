package com.codeexercise.robot.impl;


import com.codeexercise.robot.*;
import com.codeexercise.robot.exception.RobotOutsideTableException;
import com.codeexercise.robot.util.ValidateUtils;

/**
 * The simple robot implementation
 *
 */
public class ToyRobot implements Robot {

    private Location location;
    private Direction direction;
    private Table table;

    @Override
    public void place(Location location, Direction direction, Table table) throws RobotOutsideTableException {
        ValidateUtils.notNull(location, "Point can not be null");
        ValidateUtils.notNull(direction, "Direction can not be null");
        ValidateUtils.notNull(table, "Table can not be null");
        if (table.isOnTable(location)) {
            this.location = location;
            this.direction = direction;
            this.table = table;
        }else {
            throw new RobotOutsideTableException();
        }

    }

    @Override
    public void move() {
        // Do nothing if robot has not been placed on the table
        if (!isPlacedOnTable())
            return;
        Location newLocation = null;
        switch (direction) {
            case NORTH:
                newLocation = new Location(this.location.getX(), this.location.getY() + 1);
                break;
            case EAST:
                newLocation = new Location(this.location.getX() + 1, this.location.getY());
                break;
            case SOUTH:
                newLocation = new Location(this.location.getX(), this.location.getY() - 1);
                break;
            case WEST:
                newLocation = new Location(this.location.getX() - 1, this.location.getY());
                break;
        }
        if (table.isOnTable(newLocation))
            this.location = newLocation;

    }

    @Override
    public void turnLeft() {
        if (!isPlacedOnTable())
            return;
        this.direction = Compass.rotate90DegreeLeft(this.direction);
    }

    @Override
    public void turnRight() {
        if (!isPlacedOnTable())
            return;
        this.direction = Compass.rotate90DegreeRight(this.direction);
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public boolean isPlacedOnTable() {
        if (table == null || direction == null || location == null)
            return false;
        return true;
    }
}

