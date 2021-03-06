package com.galaxy.moon.pp.model.bean;

import java.math.BigDecimal;

public class WithdrawBill {
    private Long id;

    private String billNo;

    private String ipsBillNo;

    private Long userId;

    private BigDecimal amount;

    private BigDecimal ipsTrdAmt;

    private BigDecimal merFee;

    private BigDecimal ipsFee;

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

    public BigDecimal getMerFee() {
        return merFee;
    }

    public void setMerFee(BigDecimal merFee) {
        this.merFee = merFee;
    }

    public BigDecimal getIpsFee() {
        return ipsFee;
    }

    public void setIpsFee(BigDecimal ipsFee) {
        this.ipsFee = ipsFee;
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