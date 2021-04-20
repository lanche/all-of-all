package io.file.customer;

import com.opencsv.bean.CsvToBeanFilter;

/**
 * @Author hezhensheng
 * @Date 2021/4/8
 * @Description 解析CSV文件时的过滤器
 */
public class LineFilter implements CsvToBeanFilter {

    /**
     * 支付宝的账单非数据行会以“#”开头，这些行需要过滤
     */
    @Override
    public boolean allowLine(String[] line) {
        return !line[0].startsWith("#");
    }
}
