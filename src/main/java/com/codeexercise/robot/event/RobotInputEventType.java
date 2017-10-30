package com.codeexercise.robot.event;

public enum RobotInputEventType {

    /**
     * The "place robot" event. This <code>RobotInputEvent</code>
     * occurs when the input signal the "PLACE" command.
     */
    PLACE,
    /**
     * The "move robot" event. This <code>RobotInputEvent</code>
     * occurs when the input signal the "MOVE" command.
     */
    MOVE,
    /**
     * The "turn left" event. This <code>RobotInputEvent</code>
     * occurs when the input signal the "LEFT" command.
     */
    LEFT,
    /**
     * The "turn right" event. This <code>RobotInputEvent</code>
     * occurs when the input signal the "RIGHT" command.
     */
    RIGHT,
    /**
     * The "report robot position" event. This <code>RobotInputEvent</code>
     * occurs when the input signal the "REPORT" command.
     */
    REPORT
}
