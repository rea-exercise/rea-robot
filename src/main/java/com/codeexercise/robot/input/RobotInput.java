package com.codeexercise.robot.input;

import com.codeexercise.robot.RobotInputEventListener;
import com.codeexercise.robot.exception.RobotInputException;

/**
 * Robot input interface.
 */
public interface RobotInput {

    /**
     * Adds the specified robot input listener to receive command from this input.
     * If listener l is null, no exception is thrown and no action is performed.
     * @param l The Robot input event listener.
     */
    void addRobotInputEventListener(RobotInputEventListener l);


    /**
     * Start listen or accept input event
     * @throws RobotInputException if there was an error with input source
     */
    void readCommands() throws RobotInputException;

}
