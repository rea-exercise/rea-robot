package com.codeexercise.robot.input.impl;

import com.codeexercise.robot.Direction;
import com.codeexercise.robot.Location;
import com.codeexercise.robot.RobotInputEventListener;
import com.codeexercise.robot.event.RobotInputEvent;
import com.codeexercise.robot.event.RobotInputEventType;
import com.codeexercise.robot.exception.RobotInputException;
import com.codeexercise.robot.input.RobotInput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FileRobotInput implements RobotInput {

    /**
     * The place command pattern
     */
    private static final Pattern PLACE_COMMAND_PATTERN = Pattern
            .compile("^PLACE (\\d+),(\\d+),(NORTH|EAST|SOUTH|WEST)$");

    private static final String PLACE_COMMAND = "PLACE";


    private List<RobotInputEventListener> listeners = new ArrayList<RobotInputEventListener>();
    private final String filePath;


    public FileRobotInput(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void addRobotInputEventListener(RobotInputEventListener listener) {
        this.listeners.add(listener);
    }

    private void notifyListeners(RobotInputEvent robotEvent) {
        for (RobotInputEventListener listener : listeners) {
            listener.onCommand(robotEvent);
        }
    }

    @Override
    public void readCommands() throws RobotInputException {
        Stream<String> stream = null;
        try {
            stream = Files.lines(Paths.get(filePath));
        } catch (IOException e) {
            throw new RobotInputException("Can not read commands from file.", e);
        }
        stream.forEach(this::parse);

    }


    /**
     * This method parse single line into robot command.
     */
    private void parse(String line) {
        RobotInputEvent event = null;
        if (line.startsWith(PLACE_COMMAND)) {
            Matcher matcher = PLACE_COMMAND_PATTERN.matcher(line);
            if (matcher.find()) {
                Integer x = new Integer(matcher.group(1));
                Integer y = new Integer(matcher.group(2));
                Direction direction = Direction.valueOf(matcher.group(3));
                event = new RobotInputEvent(RobotInputEventType.PLACE, new Location(x, y), direction);
            }
        } else {

            RobotInputEventType eventType = RobotInputEventType.valueOf(line);
            if (eventType != null) {
                event = new RobotInputEvent(eventType);
            }
        }
        if (event != null) {
            notifyListeners(event);
        }
    }


}
