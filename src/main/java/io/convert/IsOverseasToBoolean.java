package io.convert;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

/**
 * @Author hezhensheng
 * @Date 2021/4/12
 * @Description 自定义CSV文件中数据转化器，生成bean时将文件中字符串类型的“是”改为Boolean值
 */
public class IsOverseasToBoolean<T, I> extends AbstractBeanField<T, I> {

    @Override
    protected Object convert(String s) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        return "是".equals(s);
    }

}
