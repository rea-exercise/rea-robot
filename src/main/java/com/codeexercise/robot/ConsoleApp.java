package com.codeexercise.robot;

import com.codeexercise.robot.impl.ToyRobotApplication;
import com.codeexercise.robot.input.impl.FileRobotInput;
import org.apache.commons.cli.*;

/**
 * The entry point for Toy Robot Console Application.
 *
 */
public class ConsoleApp {


    private static final String OPTION_HELP = "h";
    private static final String OPTION_FILE_INPUT = "f";
    private static final String LONG_OPTION_HELP = "help";
    private static final String LONG_OPTION_FILE_INPUT = "fileInput";

    private final Options options;
    private final ToyRobotApplication application;


    public ConsoleApp() {

        this.options = new Options();
        this.application = new ToyRobotApplication();
        options.addOption(OPTION_HELP, LONG_OPTION_HELP, false, "show help.");
        options.addOption(OPTION_FILE_INPUT, LONG_OPTION_FILE_INPUT, true, "Path to input file.");

    }

    /**
     * Parse command line args
     * @param args the command line arguments
     */
    public void parse(String[] args) {

        CommandLineParser parser = new BasicParser();

        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);

            if (cmd.hasOption(OPTION_HELP))
                help(options);

            if (cmd.hasOption(OPTION_FILE_INPUT)) {
                startRobot(cmd.getOptionValue(OPTION_FILE_INPUT));
            } else {
                help(options);
            }

        } catch (ParseException e) {
            help(options);
        }
    }

    private void help(Options options) {
        // This prints out some help
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Main", options);
        System.exit(0);
    }

    private void startRobot(String fileName){
        application.start(new FileRobotInput(fileName));
    }

    public static void main(String[] args) {
        ConsoleApp entryPoint = new ConsoleApp();
        entryPoint.parse(args);
    }
}
