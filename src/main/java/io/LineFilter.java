package io;

import com.opencsv.bean.CsvToBeanFilter;

/**
 * @Author hezhensheng
 * @Date 2021/4/8
 * @Description
 */
public class LineFilter implements CsvToBeanFilter {

    @Override
    public boolean allowLine(String[] line) {
        return line.length != 0 && !line[0].startsWith("#");
    }
}
