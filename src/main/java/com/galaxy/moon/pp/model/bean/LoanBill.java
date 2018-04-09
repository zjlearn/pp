package com.galaxy.moon.pp.model.bean;

import java.math.BigDecimal;

/**
 * create by zhangjun1 on 2017/12/20
 * 代表用户投资的单据。 主要有用户
 */
public class LoanBill {
    private Long id;
    private Long userId;
    private String userName;
    private String mobile;
    private Long projectId;   // 关联的产品Id
    private Long loanAmount;
    private BigDecimal expectRate; // 预期的利率
    private Integer loanType;  // 借款类型，与产品类型不同
    private Integer duration;  // 借款时长
    private Long asssetId; // 资产Id

    private Long createTime;
    private Integer status; // 待审核， 审核中， 已通过， 已拒绝
    private String loanRemark;
    private String statusRemark;  //已拒绝时， 保存原因


    public LoanBill() {
    }

    public Long getAsssetId() {
        return asssetId;
    }

    public void setAsssetId(Long asssetId) {
        this.asssetId = asssetId;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

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
        this.userName = userName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getExpectRate() {
        return expectRate;
    }

    public void setExpectRate(BigDecimal expectRate) {
        this.expectRate = expectRate;
    }

    public Integer getLoanType() {
        return loanType;
    }

    public void setLoanType(Integer loanType) {
        this.loanType = loanType;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLoanRemark() {
        return loanRemark;
    }

    public void setLoanRemark(String loanRemark) {
        this.loanRemark = loanRemark;
    }

    public String getStatusRemark() {
        return statusRemark;
    }

    public void setStatusRemark(String statusRemark) {
        this.statusRemark = statusRemark;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
