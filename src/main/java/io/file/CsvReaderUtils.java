package io.file;

import java.io.Reader;
import java.util.List;
import java.util.function.Consumer;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import io.file.customer.LineFilter;

/**
 * @Author hezhensheng
 * @Date 2021/4/10
 * @Description csv文件处理工具类，目前基于opencsv实现
 */
public class CsvReaderUtils {

    private CsvReaderUtils() {

    }

    /**
     * 解析CSV文件生成目标类型的对象，然后执行一些业务逻辑
     *
     * @param reader 字符输入流
     * @param type 转化类型
     * @param skipLines 从第一行起需要跳过的行数，因为有些文件表头（列名）不一定为第一行
     * @param consumer 生成bean对象之后需要执行的逻辑
     * @param <T> 后面可以考虑支持一些自定义策略
     */
    public static <T> void parseAndHandle(Reader reader, Class<? extends T> type, int skipLines, Consumer<T> consumer) {
        getCsvToBean(reader, type, skipLines).stream().forEach(consumer);
    }

    /**
     * 默认不需要跳过前面的行
     */
    public static <T> void parseAndHandle(Reader reader, Class<? extends T> type, Consumer<T> consumer) {
        parseAndHandle(reader, type, 0, consumer);
    }

    /**
     * 获取指定类型的对象集合，支持跳过指定行数
     */
    public static <T> List<T> parse(Reader reader, Class<T> type, int skipLines) {
        return getCsvToBean(reader, type, skipLines).parse();
    }

    /**
     * 获取指定类型的对象集合，默认从第一行开始解析
     */
    public static <T> List<T> parse(Reader reader, Class<T> type) {
        return getCsvToBean(reader, type, 0).parse();
    }

    /**
     * 将字符输入流转化为指定类型的CSVToBean对象，然后选择获取对象集合还是Stream流
     */
    private static <T> CsvToBean<T> getCsvToBean(Reader reader, Class<? extends T> type, int skipLines) {

        HeaderColumnNameMappingStrategy<T> strategy = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(type);

        return new CsvToBeanBuilder<T>(reader)
                .withType(type)
                .withMappingStrategy(strategy)
                .withIgnoreLeadingWhiteSpace(true)
                .withSkipLines(skipLines)
                .withFilter(new LineFilter())
                .build();

    }

}
