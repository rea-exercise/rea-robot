package com.codeexercise.robot.input;

import com.codeexercise.robot.Direction;
import com.codeexercise.robot.RobotInputEventListener;
import com.codeexercise.robot.event.RobotInputEvent;
import com.codeexercise.robot.event.RobotInputEventType;
import com.codeexercise.robot.exception.RobotInputException;
import com.codeexercise.robot.input.impl.FileRobotInput;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class FileRobotInputTest {

    private File f = null;
    private FileRobotInput input;
    ArgumentCaptor<RobotInputEvent>  eventCaptor;


    @Before
    public void setUp() throws IOException {
        eventCaptor = ArgumentCaptor.forClass(RobotInputEvent.class);
        f = File.createTempFile("tmp", ".txt");

    }

    @After
    public void cleanUpFile() {
        f.deleteOnExit();
    }

    private RobotInputEventListener setupInput(String text) throws IOException {
        input = new FileRobotInput(f.getAbsolutePath());
        RobotInputEventListener listener = mock(RobotInputEventListener.class);
        input.addRobotInputEventListener(listener);
        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        writer.write(text);
        writer.close();
        return listener;
    }



    @Test(expected = RobotInputException.class)
    public void whenReadInValidFilePathThenExceptionIsThrown() throws RobotInputException {
        input = new FileRobotInput("testDummyFile.txt");
        input.readCommands();
    }

    @Test
    public void whenReadPlaceCommandLineThenPlaceEventIsFired() throws IOException, RobotInputException {

        RobotInputEventListener listener = setupInput("PLACE 1,2,EAST");
        input.readCommands();
        verify(listener,times(1)).onCommand(eventCaptor.capture());
        assertEquals(RobotInputEventType.PLACE, eventCaptor.getValue().getEventType());
        assertEquals(1, eventCaptor.getValue().getLocation().getX());
        assertEquals(2, eventCaptor.getValue().getLocation().getY());
        assertEquals(Direction.EAST, eventCaptor.getValue().getDirection());

    }

    @Test
    public void whenReadMoveCommandLineThenMoveEventIsFired() throws IOException, RobotInputException {
        RobotInputEventListener listener = setupInput("MOVE");
        input.readCommands();
        verify(listener,times(1)).onCommand(eventCaptor.capture());
        assertEquals(RobotInputEventType.MOVE, eventCaptor.getValue().getEventType());
    }

    @Test
    public void whenReadLeftCommandLineThenLeftEventIsFired() throws IOException, RobotInputException {
        RobotInputEventListener listener = setupInput("LEFT");
        input.readCommands();
        verify(listener,times(1)).onCommand(eventCaptor.capture());
        assertEquals(RobotInputEventType.LEFT, eventCaptor.getValue().getEventType());
    }

    @Test
    public void whenReadRightCommandLineThenRightEventIsFired() throws IOException, RobotInputException {
        RobotInputEventListener listener = setupInput("RIGHT");
        input.readCommands();
        verify(listener,times(1)).onCommand(eventCaptor.capture());
        assertEquals(RobotInputEventType.RIGHT, eventCaptor.getValue().getEventType());
    }

    @Test
    public void whenReadReportCommandLineThenReportEventIsFired() throws IOException, RobotInputException {
        RobotInputEventListener listener = setupInput("REPORT");
        input.readCommands();
        verify(listener,times(1)).onCommand(eventCaptor.capture());
        assertEquals(RobotInputEventType.REPORT, eventCaptor.getValue().getEventType());
    }

    @Test
    public void whenReadMultipleCommandLinesThenMultipleEventsIsFired() throws IOException, RobotInputException {
        RobotInputEventListener listener = setupInput("PLACE 1,2,EAST\nMOVE\nREPORT\n");
        input.readCommands();
        verify(listener,times(3)).onCommand(eventCaptor.capture());
    }


}
