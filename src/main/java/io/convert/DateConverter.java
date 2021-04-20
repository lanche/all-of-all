package io.convert;

import java.text.ParseException;

import org.apache.commons.lang3.time.DateUtils;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvBadConverterException;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

/**
 * @Author hezhensheng
 * @Date 2021/4/12
 * @Description 自定义CSV文件中数据转化器，生成bean时将文件中字符串类型的时间改为long型时间戳
 */
public class DateConverter<T, I> extends AbstractBeanField<T, I> {

    @Override
    protected Object convert(String s) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        try {
            return DateUtils.parseDate(s, "yyyy-MM-dd hh:mm:ss").getTime();
        } catch (ParseException e) {
            throw new CsvBadConverterException(String.format("账单中日期%s格式不合法", s));
        }
    }
}
