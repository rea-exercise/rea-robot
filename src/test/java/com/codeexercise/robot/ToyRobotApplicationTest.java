package com.codeexercise.robot;

import com.codeexercise.robot.display.Display;
import com.codeexercise.robot.event.RobotInputEvent;
import com.codeexercise.robot.event.RobotInputEventType;
import com.codeexercise.robot.exception.RobotInputException;
import com.codeexercise.robot.exception.RobotOutsideTableException;
import com.codeexercise.robot.impl.ToyRobotApplication;
import com.codeexercise.robot.input.impl.FileRobotInput;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ToyRobotApplicationTest {

    private Robot robot;
    private Table table;
    private Display display;
    private ToyRobotApplication toyRobotApplication;

    @Before
    public void setUp() {
        robot = mock(Robot.class);
        table = mock(Table.class);
        display = mock(Display.class);
        toyRobotApplication = new ToyRobotApplication(robot,table,display);
    }

    @Test
    public void whenPlaceInputEventIsFiredThenRobotPlaceShouldHasBeenCall() throws RobotOutsideTableException {
        Location l = new Location(1,1);
        Direction d = Direction.EAST;
        RobotInputEvent inputEvent = new RobotInputEvent(RobotInputEventType.PLACE,l, d);
        toyRobotApplication.onCommand(inputEvent);
        verify(robot,times(1)).place(l,d,table);
    }

    @Test
    public void whenMoveInputEventIsFiredThenRobotMoveShouldHasBeenCall() {

        RobotInputEvent inputEvent = new RobotInputEvent(RobotInputEventType.MOVE);
        toyRobotApplication.onCommand(inputEvent);
        verify(robot,times(1)).move();
    }

    @Test
    public void whenLeftInputEventIsFiredThenRobotTurnLeftShouldHasBeenCall() {

        RobotInputEvent inputEvent = new RobotInputEvent(RobotInputEventType.LEFT);
        toyRobotApplication.onCommand(inputEvent);
        verify(robot,times(1)).turnLeft();
    }

    @Test
    public void whenRightInputEventIsFiredThenRobotTurnRightShouldHasBeenCall() {

        RobotInputEvent inputEvent = new RobotInputEvent(RobotInputEventType.RIGHT);
        toyRobotApplication.onCommand(inputEvent);
        verify(robot,times(1)).turnRight();
    }

    @Test
    public void whenReportInputEventIsFiredThenDisplayShowShouldHasBeenCall() {

        RobotInputEvent inputEvent = new RobotInputEvent(RobotInputEventType.REPORT);
        toyRobotApplication.onCommand(inputEvent);
        verify(display,times(1)).show(robot.report());
    }

    @Test
    public void whenStartWithInvalidInputThenErrorShouldHasBeenDisplay() throws RobotInputException {
        FileRobotInput input = mock(FileRobotInput.class);
        Exception ex = new Exception();
        doThrow(new RobotInputException("Test", ex)).when(input).readCommands();
        toyRobotApplication.start(input);
        verify(display,times(1)).show("ERROR: Test");
    }



}
