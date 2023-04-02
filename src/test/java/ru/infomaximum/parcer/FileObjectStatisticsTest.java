package ru.infomaximum.parcer;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;

public class FileObjectStatisticsTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream ORIGINAL_OUT = System.out;
    private static final String CSV_FILE_PATH = "src/test/resources/test_csv.csv";
    private static final String JSON_FILE_PATH = "src/test/resources/test_json.json";
    private static final String EXPECTED_FILE_PATH = "src/test/resources/expected_lines.txt";

    @BeforeEach
    void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStream() {
        System.setOut(ORIGINAL_OUT);
    }


    @ParameterizedTest
    @ValueSource(strings = {CSV_FILE_PATH, JSON_FILE_PATH})
    void csvTest(String filePath) throws IOException {

        BufferedReader testFileReader = new BufferedReader(new FileReader(filePath));

        FileObjectStatistics fileObjectStatistics = null;

        switch (filePath) {
            case CSV_FILE_PATH:
                fileObjectStatistics = new FileObjectCsvStatistics(testFileReader);
                break;
            case JSON_FILE_PATH:
                fileObjectStatistics = new FileObjectJsonStatistics(testFileReader);
                break;
        }

        fileObjectStatistics.printStatistics();

        BufferedReader expectedLinesReader = new BufferedReader(new FileReader(EXPECTED_FILE_PATH));

        BufferedReader testingReader = new BufferedReader(
                new InputStreamReader(
                        new ByteArrayInputStream(outContent.toByteArray())));

        String testingLine;
        int lineNumber = 0;

        while ((testingLine = testingReader.readLine()) != null) {
            Assertions.assertEquals(expectedLinesReader.readLine(), testingLine, "Line number " + lineNumber);
            lineNumber++;
        }
    }
}
