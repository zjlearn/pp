package com.galaxy.moon.pp.model.dto;

public class ModifyProjectDTO {
    private String merBillNo;
    private String merDate;
    private String projectNo;
    private String modifyType;
    private String projectStatus;
    private Double projectAmt;
    private Integer repaymentNumber;
    private Double closingCost;

    public ModifyProjectDTO() {
    }

    public String getMerBillNo() {
        return merBillNo;
    }

    public void setMerBillNo(String merBillNo) {
        this.merBillNo = merBillNo;
    }

    public String getMerDate() {
        return merDate;
    }

    public void setMerDate(String merDate) {
        this.merDate = merDate;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getModifyType() {
        return modifyType;
    }

    public void setModifyType(String modifyType) {
        this.modifyType = modifyType;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Double getProjectAmt() {
        return projectAmt;
    }

    public void setProjectAmt(Double projectAmt) {
        this.projectAmt = projectAmt;
    }

    public Integer getRepaymentNumber() {
        return repaymentNumber;
    }

    public void setRepaymentNumber(Integer repaymentNumber) {
        this.repaymentNumber = repaymentNumber;
    }

    public Double getClosingCost() {
        return closingCost;
    }

    public void setClosingCost(Double closingCost) {
        this.closingCost = closingCost;
    }
}
