package com.galaxy.moon.pp.model;

import java.util.Date;

public class Product {
    private Long id;

    private String productNo;

    private String productName;

    private Integer productType;

    private Integer productDetailId;

    private Double amount;

    private Integer rateType;

    private Double rateReturn;

    private Double rateMin;

    private Double rateMax;

    private Integer duration;

    private Integer lowerLimit;

    private Integer autoInvest;

    private Integer remainder;

    private Byte status;

    private Long createTime;

    private Date updateTime;

    private Long deleteTime;

    private Integer deleteFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(Integer productDetailId) {
        this.productDetailId = productDetailId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getRateReturn() {
        return rateReturn;
    }

    public void setRateReturn(Double rateReturn) {
        this.rateReturn = rateReturn;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(Integer lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public Integer getAutoInvest() {
        return autoInvest;
    }

    public void setAutoInvest(Integer autoInvest) {
        this.autoInvest = autoInvest;
    }

    public Integer getRemainder() {
        return remainder;
    }

    public void setRemainder(Integer remainder) {
        this.remainder = remainder;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Long deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public Integer getRateType() {
        return rateType;
    }

    public void setRateType(Integer rateType) {
        this.rateType = rateType;
    }

    public Double getRateMin() {
        return rateMin;
    }

    public void setRateMin(Double rateMin) {
        this.rateMin = rateMin;
    }

    public Double getRateMax() {
        return rateMax;
    }

    public void setRateMax(Double rateMax) {
        this.rateMax = rateMax;
    }
}