package com.codeexercise.robot.display;

import com.codeexercise.robot.display.impl.ConsoleDisplay;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ConsoleDisplayTest {

    private PrintStream stream;
    private ConsoleDisplay display;

    @Before
    public void setUp() {
        stream = mock(PrintStream.class);
        display = new ConsoleDisplay(stream);
    }

    @Test
    public void whenShowTextCallThenItShowOnScreen(){
        display.show("Test");
        verify(stream).println("Test");
    }

}