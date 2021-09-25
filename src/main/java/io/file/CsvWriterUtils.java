package io.file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

/**
 * @Author hezhensheng
 * @Date 2021/4/19
 * @Description
 */
public class CsvWriterUtils {

    public static <T> void write(String fileName, List<T> beans) throws IOException {
        Writer writer = new FileWriter(fileName);

        StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer).build();
        try {
            beanToCsv.write(beans);
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
        writer.flush();
        writer.close();
    }

}
