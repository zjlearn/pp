package com.galaxy.moon.pp.model.bean;

import java.math.BigDecimal;

/**
 * 借款的单据信息
 */
public class LoanBill {
    private Long id;

    private Long userId;

    private String userName;

    private String mobile;

    private Long projectId;

    private BigDecimal loanAmount;

    private BigDecimal expectRate;

    private Byte loanType;

    private Integer duration;

    private Long asssetId;

    private String district;

    private Byte status;

    private String loanRemark;

    private String statusRemark;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getExpectRate() {
        return expectRate;
    }

    public void setExpectRate(BigDecimal expectRate) {
        this.expectRate = expectRate;
    }

    public Byte getLoanType() {
        return loanType;
    }

    public void setLoanType(Byte loanType) {
        this.loanType = loanType;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Long getAsssetId() {
        return asssetId;
    }

    public void setAsssetId(Long asssetId) {
        this.asssetId = asssetId;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getLoanRemark() {
        return loanRemark;
    }

    public void setLoanRemark(String loanRemark) {
        this.loanRemark = loanRemark == null ? null : loanRemark.trim();
    }

    public String getStatusRemark() {
        return statusRemark;
    }

    public void setStatusRemark(String statusRemark) {
        this.statusRemark = statusRemark == null ? null : statusRemark.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}