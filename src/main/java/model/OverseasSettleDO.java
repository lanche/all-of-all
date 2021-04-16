package model;

/**
 * @Author hezhensheng
 * @Date 2021/4/9
 * @Description
 */
public class OverseasSettleDO {

    private long id;
    private String tradeNo;
    private String outRequestNo;
    private long settleAmount;
    private long foreignSettleAmount;
    private String exchangeRate;
    private String batchNo;
    private String settleNo;
    private long tradeTime;
    private String bizType;
    private boolean overseas;
    private String currency;
    private String merchantId;
    private long createTime;
    private long updateTime;
    private int isSend;
    private int provider;
    private String billDate;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOutRequestNo() {
        return outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        this.outRequestNo = outRequestNo;
    }

    public long getSettleAmount() {
        return settleAmount;
    }

    public void setSettleAmount(long settleAmount) {
        this.settleAmount = settleAmount;
    }

    public long getForeignSettleAmount() {
        return foreignSettleAmount;
    }

    public void setForeignSettleAmount(long foreignSettleAmount) {
        this.foreignSettleAmount = foreignSettleAmount;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getSettleNo() {
        return settleNo;
    }

    public void setSettleNo(String settleNo) {
        this.settleNo = settleNo;
    }

    public long getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(long tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public boolean isOverseas() {
        return overseas;
    }

    public void setOverseas(boolean overseas) {
        this.overseas = overseas;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public int getIsSend() {
        return isSend;
    }

    public void setIsSend(int isSend) {
        this.isSend = isSend;
    }

    public int getProvider() {
        return provider;
    }

    public void setProvider(int provider) {
        this.provider = provider;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }
}
