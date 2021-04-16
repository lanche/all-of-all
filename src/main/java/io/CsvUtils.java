package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Consumer;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.exceptions.CsvValidationException;

import io.model.Flow;
import sun.nio.cs.ext.GBK;

/**
 * @Author hezhensheng
 * @Date 2021/4/8
 * @Description
 */
public class CsvUtils {

    public static void main(String[] args) throws IOException {

        //String fileName = "src/main/resources/2088.csv";
        String fileName = "src/main/resources/账单字段样例.csv";
        //csvReader(fileName, "#");
        // csvReadBean(fileName);
        handle(fileName);
    }

    public static void csvReader(String fileName, String ignorePrefix) {
        try (FileInputStream fis = new FileInputStream(fileName);
                InputStreamReader isr = new InputStreamReader(fis,
                        new GBK());
                CSVReader reader = new CSVReader(isr)) {
            String[] nextLine;

            while ((nextLine = reader.readNext()) != null) {
                if (nextLine.length != 0 && nextLine[0].startsWith(ignorePrefix)) {
                    continue;
                }
                for (String e : nextLine) {
                    System.out.format("%s | ", e);
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    public static void csvReadBean(String fileName) throws IOException {

        Path myPath = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(myPath,
                new GBK())) {

            HeaderColumnNameMappingStrategy<Flow> strategy
                    = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(Flow.class);

            CsvToBean csvToBean = new CsvToBeanBuilder(br)
                    .withType(Flow.class)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(4)
                    .withFilter(new LineFilter())
                    .build();

            List<Flow> flows = csvToBean.parse();

            flows.forEach(e -> {
                System.out.println(e.toString());
            });
        }
    }

    public static void handle(String fileName) throws IOException {
        Path myPath = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(myPath,
                StandardCharsets.UTF_8)) {
            parse(br, Flow.class, e -> {
                System.out.println(e.getClass().getName());
                System.out.println(e.toString());
            });
        }
    }

    /**
     * 将CSV文件每一行数据转化为指定的对象，然后执行对应的逻辑
     * @param reader
     * @param type
     * @param consumer
     * @param <T>
     */
    /**
     * 可选参数：strategy、
     * 某一行的解析失败不会影响下一行的解析，最后会统一抛出异常，所以需要在最后决定是否捕获异常（某一行处理失败了是否影响main线程后面的逻辑继续执行）
     */

    public static <T> void parse(Reader reader, Class<? extends T> type, Consumer<T> consumer) {
        HeaderColumnNameMappingStrategy<T> strategy
                = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(type);

        CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
                .withType(type)
                .withMappingStrategy(strategy)
                .withIgnoreLeadingWhiteSpace(true)
                .withSkipLines(4)
                .withFilter(new LineFilter())
                .build();

        csvToBean.stream().forEach(consumer);
    }
}
