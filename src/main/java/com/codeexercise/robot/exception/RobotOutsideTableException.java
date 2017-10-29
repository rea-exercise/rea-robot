package com.codeexercise.robot.exception;

/**
 * Exception thrown when place robot outside the table.
 */
public class RobotOutsideTableException extends Exception {

    public RobotOutsideTableException() {
        super("Can not place robot outside the table.");
    }
}