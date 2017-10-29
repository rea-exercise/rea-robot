package com.codeexercise.robot.util;

public class ValidateUtils {


    /**
     * *
     * <p>
     * Validate that the argument condition is <code>true</code>; otherwise
     * throwing an exception with the specified message.
     * </p>
     *
     * @param expression
     *            the boolean expression to check
     * @param message
     *            the exception message if invalid
     * @throws IllegalArgumentException
     *             if expression is <code>false</code>
     */
    public static void isTrue(boolean expression, String message) {
        if (expression == false) {
            throw new IllegalArgumentException(message);
        }
    }


}
