package io.model;

import com.opencsv.bean.CsvBindByName;

/**
 * @Author hezhensheng
 * @Date 2021/4/8
 * @Description
 */
public class Flow {

    @CsvBindByName(column = "商户结算请求号", required = true)
    private String outRequestNo;

    @CsvBindByName(column = "支付宝交易号", required = true)
    private String transNo;

    @CsvBindByName(column = "人民币金额", required = true)
    private String money;

    public String getOutRequestNo() {
        return outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        this.outRequestNo = outRequestNo;
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Flow{" +
                "outRequestNo='" + outRequestNo + '\'' +
                ", transNo='" + transNo + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}
