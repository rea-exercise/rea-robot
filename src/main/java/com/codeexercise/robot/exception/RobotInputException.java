package com.codeexercise.robot.exception;

/**
 * Exception thrown when the was an error with input source
 */
public class RobotInputException extends Exception {

    public RobotInputException(String message, Throwable e){
        super(message, e);
    }

}
