package com.codeexercise.robot.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Test case for validation utils class
 *
 */
public class ValidateUtilsTest {

    @Test
    public void whenNullIsUsedThenExceptionIsThrown() {

        try {
            ValidateUtils.notNull(null, "Ohh!!! Object is null");
            fail("Expecting NullPointerException");
        } catch (final NullPointerException ex) {
            assertEquals("Ohh!!! Object is null", ex.getMessage());
        }

    }

    @Test
    public void whenObjectIsUsedThenNoExceptionIsThrown() {

        ValidateUtils.notNull(new Object(), "Exception should not be thrown");
        assertTrue(true);
    }

    @Test
    public void WhenFalseIsUsedThenExceptionIsThrown() {
        try {
            ValidateUtils.isTrue(false,"The validated expression is false");
            fail("Expecting IllegalArgumentException");
        } catch (final IllegalArgumentException ex) {
            assertEquals("The validated expression is false", ex.getMessage());
        }
    }

    @Test
    public void WhenTrueIsUsedThenNoExceptionIsThrown() {
        ValidateUtils.isTrue(true,"The validated expression is true");
        assertTrue(true);
    }

}