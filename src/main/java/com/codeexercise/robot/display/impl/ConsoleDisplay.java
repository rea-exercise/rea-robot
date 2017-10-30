package com.codeexercise.robot.display.impl;

import com.codeexercise.robot.display.Display;

import java.io.PrintStream;

/**
 * Display text to console output.
 */
public class ConsoleDisplay implements Display {

    private final PrintStream printStream;

    public ConsoleDisplay(PrintStream printStream){
        this.printStream = printStream;
    }


    @Override
    public void show(String text) {

        printStream.println(text);
    }
}
