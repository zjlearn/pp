package com.galaxy.moon.pp.model.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Project {
    private Long id;

    private String projectNo;

    private String projectName;

    private Integer projectType;

    private Integer projectDetailId;

    private BigDecimal amount;

    private Double rateReturn;

    private Integer duration;

    private Integer lowerLimit;

    private Integer autoInvest;

    private Integer remainder;

    private Integer repayType; //还款类型


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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public Integer getProjectType() {
        return projectType;
    }

    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    public Integer getProjectDetailId() {
        return projectDetailId;
    }

    public void setProjectDetailId(Integer projectDetailId) {
        this.projectDetailId = projectDetailId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
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

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }
}