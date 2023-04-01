package ru.infomaximum.parcer;

import com.opencsv.bean.CsvToBeanBuilder;
import ru.infomaximum.object.FileObject;

import java.io.BufferedReader;
import java.io.IOException;

public class FileObjectCsvStatistics extends FileObjectStatistics {

    public FileObjectCsvStatistics(BufferedReader fileReader) throws IOException {
        this.objects = new CsvToBeanBuilder(fileReader).withType(FileObject.class).build().parse();
//        objectsStream = new CsvToBeanBuilder(fileReader).withType(FileObject.class).build().parse().stream();
    }
}
