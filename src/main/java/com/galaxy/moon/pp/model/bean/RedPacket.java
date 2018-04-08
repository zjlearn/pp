package com.galaxy.moon.pp.model.bean;

import java.math.BigDecimal;

public class RedPacket {
    private Long id;

    private Long userId;

    private String packetName;

    private Integer packetType;

    private BigDecimal packetAmount;

    private Integer periodValidity;

    private Integer durtionLimit;

    private Integer amountLimit;

    private Integer status;

    private Long createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPacketName() {
        return packetName;
    }

    public void setPacketName(String packetName) {
        this.packetName = packetName == null ? null : packetName.trim();
    }

    public Integer getPacketType() {
        return packetType;
    }

    public void setPacketType(Integer packetType) {
        this.packetType = packetType;
    }

    public BigDecimal getPacketAmount() {
        return packetAmount;
    }

    public void setPacketAmount(BigDecimal packetAmount) {
        this.packetAmount = packetAmount;
    }

    public Integer getPeriodValidity() {
        return periodValidity;
    }

    public void setPeriodValidity(Integer periodValidity) {
        this.periodValidity = periodValidity;
    }

    public Integer getDurtionLimit() {
        return durtionLimit;
    }

    public void setDurtionLimit(Integer durtionLimit) {
        this.durtionLimit = durtionLimit;
    }

    public Integer getAmountLimit() {
        return amountLimit;
    }

    public void setAmountLimit(Integer amountLimit) {
        this.amountLimit = amountLimit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}