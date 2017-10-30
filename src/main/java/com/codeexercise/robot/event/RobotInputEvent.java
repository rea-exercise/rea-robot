package com.codeexercise.robot.event;

import com.codeexercise.robot.Direction;
import com.codeexercise.robot.Location;

/**
 * The root event class for all robot input events.
 * <p>
 * Robot Input events are delivered to listeners before they are
 * processed normally by the source where they originated.
 */
public class RobotInputEvent {


    private Location location;
    private Direction direction;
    private final RobotInputEventType eventType;


    /**
     * Constructs a <code>RobotInputEvent</code> object
     *
     * @param eventType An integer indicating the type of event.
     */
    public RobotInputEvent(RobotInputEventType eventType) {
        this.eventType = eventType;
    }


    /**
     * Constructs a <code>RobotInputEvent</code> object
     *
     * @param eventType An integer indicating the type of event.
     * @param location  the location on which robot is placed
     * @param direction the direction which robot is facing on the table
     */
    public RobotInputEvent(RobotInputEventType eventType, Location location, Direction direction) {
        this(eventType);
        this.location = location;
        this.direction = direction;
    }

    /**
     * Returns the event type.
     */
    public RobotInputEventType getEventType() {
        return eventType;
    }

    /**
     * @return Location to place robot into the table.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @return the Direction that the robot is facing.
     */
    public Direction getDirection() {
        return direction;
    }
}
