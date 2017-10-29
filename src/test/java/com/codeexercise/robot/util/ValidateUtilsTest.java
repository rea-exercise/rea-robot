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