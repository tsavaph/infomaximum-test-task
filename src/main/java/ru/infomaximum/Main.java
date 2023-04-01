package ru.infomaximum;

import ru.infomaximum.exception.IncorrectFileFormatException;
import ru.infomaximum.parcer.FileObjectCsvStatistics;
import ru.infomaximum.parcer.FileObjectJsonStatistics;
import ru.infomaximum.parcer.FileObjectStatistics;

import java.io.*;

public class Main {
    private final static String EXIT_COMMAND = "exit";
    public static void main(String[] args) {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.printf("Enter a path to JSON or CSV file. Type \"%s\" to exit.%n", EXIT_COMMAND);
                String consoleLine = consoleReader.readLine();

                if (consoleLine.equals(EXIT_COMMAND))
                    break;

                BufferedReader fileReader = new BufferedReader(new FileReader(consoleLine));
                FileObjectStatistics fileObjectStatistics;

                if (consoleLine.endsWith(".json")) {
                    fileObjectStatistics = new FileObjectJsonStatistics(fileReader);
                } else if (consoleLine.endsWith(".csv")) {
                    fileObjectStatistics = new FileObjectCsvStatistics(fileReader);
                } else {
                    throw new IncorrectFileFormatException();
                }

                fileObjectStatistics.printStatistics();

                fileReader.close();

            } catch (FileNotFoundException e) {
                System.out.println("File has not found. Please type a correct file path.");
            } catch (IOException e) {
                System.out.println("Unknown error. Please type again.");
            } catch (IncorrectFileFormatException e) {
                System.out.println("Incorrect file format.");
            }

        }

    }
}
