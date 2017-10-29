package com.codeexercise.robot;

import com.codeexercise.robot.exception.RobotOutsideTableException;

/**
 * A Robot.
 * The user of this interface has precise control over robot action
 */
public interface Robot {


    /**
     * Put the toy robot on the table in position X,Y and facing Direction
     * (NORTH,SOUTH, EAST or WEST). The origin (0,0) is the SOUTH WEST most
     * corner.
     *
     * @param location
     *            the location on which robot is placed
     * @param direction
     *            the direction which robot is facing on the table
     * @param table
     *            table on which robot is place on
     *
     * @throws RobotOutsideTableException when location is outside the table
     */
    void place(Location location, Direction direction, Table table) throws RobotOutsideTableException;

    /**
     * <p>This will move the toy robot one unit forward in the direction it is
     * currently facing</p>
     * <p>The origin (0,0) is the SOUTH WEST most corner.</p>
     * <ul>
     * 	<li>
     * 		Move when Facing NORTH
     * 		<ul>
     * 			<li>Coordinate X is not changed</li>
     * 			<li>Coordinate Y is increased by one. Y = Y+ 1</li>
     * 		</ul>
     * 	</li>
     * 	<li>
     * 		Move when Facing EAST
     * 		<ul>
     * 			<li>Coordinate X is increased by one. X = X + 1</li>
     * 			<li>Coordinate Y is not changed.</li>
     * 		</ul>
     * 	</li>
     *  <li>
     * 		Move when Facing SOUTH
     * 		<ul>
     * 			<li>Coordinate X is not changed</li>
     * 			<li>Coordinate Y is decreased by one. Y = Y - 1</li>
     * 		</ul>
     * 	</li>
     *  <li>
     * 		Move when Facing WEST
     * 		<ul>
     * 			<li>Coordinate X is decreased by one. X = X -1</li>
     * 			<li>Coordinate Y is not changed</li>
     * 		</ul>
     * 	</li>
     * </ul>
     *
     * <p> Any movement that would result in the robot falling from the table
     * must be prevented, however further valid movement commands is allowed. </p>
     */
    void move();

    /**
     * This will rotate the robot 90 degrees to the left in the specified
     * direction without changing the position of the robot
     * [->NORTH->WEST->SOUTH->EAST->]
     *
     */
    void turnLeft();

    /**
     * This will rotate the robot 90 degrees to the right in the specified
     * direction without changing the position of the robot
     *  [->NORTH->EAST->SOUTH->WEST->]
     */
    void turnRight();


    /**
     * Returns direction on which robot is facing.
     *
     * @return direction on which robot is facing
     */
    Direction getDirection();


    /**
     * Return the current location on the table.
     *
     * @return Location on the table ; null otherwise.
     */
    Location getLocation();

    /**
     * Check if the robot has been placed on the table
     * @return true if the robot has been placed on the table; false otherwise.
     */
    boolean isPlacedOnTable();
}