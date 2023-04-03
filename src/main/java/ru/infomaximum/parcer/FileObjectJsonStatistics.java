package ru.infomaximum.parcer;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.infomaximum.object.ParsingFileObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileObjectJsonStatistics extends FileObjectStatistics {

    public FileObjectJsonStatistics(BufferedReader fileReader) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        Stream<ParsingFileObject> parsingFileObjectStream = Arrays.stream(mapper.readValue(fileReader, ParsingFileObject[].class));

        this.setObjects(parsingFileObjectStream);

    }
}
