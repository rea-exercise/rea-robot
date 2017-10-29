package com.codeexercise.robot;

import com.codeexercise.robot.impl.SquareTable;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test of SquareTable's implementation.
 */
public class SquareTableTest {

    @Test(expected = IllegalArgumentException.class)
    public final void whenSizeIsNegativeThenExceptionIsThrown() {
        new SquareTable(-4);
    }


    public final void whenXAndYArePositiveThenNoExceptionIsThrown(){
        new SquareTable(5);
        assertTrue(true);
    }

    @Test
    public final void whenPointIsOnTableThenReturnTrue() {

        SquareTable table = new SquareTable(4);
        assertTrue("Location(0,0) should be on the Table with size = 4",table.isOnTable(new Location(0, 0)));
        assertTrue("Location(0,4) should be on the Table with size = 4",table.isOnTable(new Location(0, 4)));
        assertTrue("Location(4,0) should be on the Table with size = 4",table.isOnTable(new Location(4, 0)));
        assertTrue("Location(4,4) should be on the Table with size = 4",table.isOnTable(new Location(4, 4)));
        assertTrue("Location(1,3) should be on the Table with size = 4",table.isOnTable(new Location(1, 3)));
    }


    @Test
    public final void whenPointIsNotOnTableThenReturnFalse(){

        SquareTable table = new  SquareTable(4);
        assertFalse("Location(-1,0) shouldn't be on the Table with size = 4",table.isOnTable(new Location(-1,0)));
        assertFalse("Location(5,0) shouldn't be on the Table with size = 4",table.isOnTable(new Location(5,0)));
        assertFalse("Location(0,-1) shouldn't be on the Table with size = 4",table.isOnTable(new Location(0,-1)));
        assertFalse("Location(0,5) shouldn't be on the Table with size = 4",table.isOnTable(new Location(0, 5)));
    }
}