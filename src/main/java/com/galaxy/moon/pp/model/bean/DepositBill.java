package com.galaxy.moon.pp.model.bean;

import java.math.BigDecimal;

public class DepositBill {
    private Long id;

    private String billNo;

    private String ipsBillNo;

    private Long userId;

    private Byte depositType;

    private Byte channelType;

    private String bankCode;

    private String bankName;

    private BigDecimal amount;

    private BigDecimal ipsTrdAmt;

    private BigDecimal ipsFee;

    private BigDecimal merFee;

    private String ipsDoTime;

    private Byte status;

    private Long createTime;

    private Long updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    public String getIpsBillNo() {
        return ipsBillNo;
    }

    public void setIpsBillNo(String ipsBillNo) {
        this.ipsBillNo = ipsBillNo == null ? null : ipsBillNo.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getDepositType() {
        return depositType;
    }

    public void setDepositType(Byte depositType) {
        this.depositType = depositType;
    }

    public Byte getChannelType() {
        return channelType;
    }

    public void setChannelType(Byte channelType) {
        this.channelType = channelType;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getIpsTrdAmt() {
        return ipsTrdAmt;
    }

    public void setIpsTrdAmt(BigDecimal ipsTrdAmt) {
        this.ipsTrdAmt = ipsTrdAmt;
    }

    public BigDecimal getIpsFee() {
        return ipsFee;
    }

    public void setIpsFee(BigDecimal ipsFee) {
        this.ipsFee = ipsFee;
    }

    public BigDecimal getMerFee() {
        return merFee;
    }

    public void setMerFee(BigDecimal merFee) {
        this.merFee = merFee;
    }

    public String getIpsDoTime() {
        return ipsDoTime;
    }

    public void setIpsDoTime(String ipsDoTime) {
        this.ipsDoTime = ipsDoTime == null ? null : ipsDoTime.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}