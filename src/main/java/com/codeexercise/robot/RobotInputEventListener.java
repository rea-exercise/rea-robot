package com.codeexercise.robot;


import com.codeexercise.robot.event.RobotInputEvent;

/**
 *
 * The listener interface for receiving "interesting" robot command
 * (PLACE, MOVE, RIGHT, LEFT, and REPORT) on a input component.
 *
 */
public interface RobotInputEventListener {

    /**
     * Invoked when the robot command is read.
     * @param event The robot input event.
     */
    void onCommand(RobotInputEvent event);

}
