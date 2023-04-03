package ru.infomaximum.parcer;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import ru.infomaximum.object.ParsingFileObject;

import java.io.BufferedReader;
import java.io.IOException;

public class FileObjectCsvStatistics extends FileObjectStatistics {

    public FileObjectCsvStatistics(BufferedReader fileReader) throws IOException {

        CsvToBean<ParsingFileObject> csvToBean = new CsvToBeanBuilder<ParsingFileObject>(fileReader)
                .withType(ParsingFileObject.class)
                .build();

        this.setObjects(csvToBean.stream());

    }
}
