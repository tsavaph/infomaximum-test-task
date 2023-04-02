package ru.infomaximum.parcer;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.infomaximum.object.FileObject;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class FileObjectJsonStatistics extends FileObjectStatistics {

    public FileObjectJsonStatistics(BufferedReader fileReader) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        setObjects(Arrays.asList(mapper.readValue(fileReader, FileObject[].class)));
    }
}
