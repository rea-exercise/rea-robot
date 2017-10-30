package com.codeexercise.robot.util;

public class ValidateUtils {


    /**
     * <p>Check that the specified argument is not null;
     * otherwise throwing an exception with the specified message.
     *
     * <pre>Utils.notNull(myObject, "The object must not be null");</pre>
     *
     * @param <T> the object type
     * @param object  the object to check
     * @param message  the exception message if invalid, not null
     * @return the validated object (never null for method chaining)
     * @throws NullPointerException if the object is null
     */
    public static <T> void notNull(final T object, final String message) {
        if (object == null) {
            throw new NullPointerException(message);
        }
    }

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
