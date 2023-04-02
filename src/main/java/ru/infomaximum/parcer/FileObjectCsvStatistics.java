package ru.infomaximum.parcer;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import ru.infomaximum.object.FileObject;

import java.io.BufferedReader;
import java.io.IOException;

public class FileObjectCsvStatistics extends FileObjectStatistics {

    public FileObjectCsvStatistics(BufferedReader fileReader) throws IOException {


        CsvToBean<FileObject> csvToBean = new CsvToBeanBuilder<FileObject>(fileReader)
                .withType(FileObject.class)
                .build();

        setObjects(csvToBean.parse());

    }
}
