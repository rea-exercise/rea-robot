package com.codeexercise.robot.impl;

import com.codeexercise.robot.Robot;
import com.codeexercise.robot.RobotInputEventListener;
import com.codeexercise.robot.Table;
import com.codeexercise.robot.display.Display;
import com.codeexercise.robot.event.RobotInputEvent;
import com.codeexercise.robot.exception.RobotInputException;
import com.codeexercise.robot.exception.RobotOutsideTableException;
import com.codeexercise.robot.input.RobotInput;

public class ToyRobotApplication implements RobotInputEventListener {

    private final Robot robot;
    private final Table table;
    private final Display display;


    public ToyRobotApplication(Robot robot, Table table, Display display){
        this.robot = robot;
        this.table = table;
        this.display = display;

    }

    public void start(RobotInput robotInput){
        try {
            robotInput.addRobotInputEventListener(this);
            robotInput.readCommands();
        } catch (RobotInputException e) {
            display.show("ERROR: " + e.getMessage());
        }
    }

    @Override
    public void onCommand(RobotInputEvent event) {

        switch (event.getEventType()) {
            case PLACE:
                try {
                    this.robot.place(event.getLocation(), event.getDirection(), table);
                } catch (RobotOutsideTableException e) {
                    display.show("WARN: " + e.getMessage());
                }
                break;
            case LEFT:
                this.robot.turnLeft();
                break;
            case RIGHT:
                this.robot.turnRight();
                break;
            case MOVE:
                this.robot.move();
                break;
            case REPORT:
                display.show(robot.report());
                break;
            default:
                break;

        }

    }
}
