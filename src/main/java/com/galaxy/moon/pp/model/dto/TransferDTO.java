package com.galaxy.moon.pp.model.dto;


import java.util.List;

public class TransferDTO  {  //all checked

	public String isAutoRepayment;
	public String transferType;
	public String projectNo;
	public String transferMode;
	public String batchNo;
	public String merDate;
	public List<TransferAccDetail> transferAccDetail;
	public String s2SUrl;

	public TransferDTO() {
	}

	public String getIsAutoRepayment() {
		return isAutoRepayment;
	}

	public void setIsAutoRepayment(String isAutoRepayment) {
		this.isAutoRepayment = isAutoRepayment;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public String getTransferMode() {
		return transferMode;
	}

	public void setTransferMode(String transferMode) {
		this.transferMode = transferMode;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getMerDate() {
		return merDate;
	}

	public void setMerDate(String merDate) {
		this.merDate = merDate;
	}

	public List<TransferAccDetail> getTransferAccDetail() {
		return transferAccDetail;
	}

	public void setTransferAccDetail(List<TransferAccDetail> transferAccDetail) {
		this.transferAccDetail = transferAccDetail;
	}

	public String getS2SUrl() {
		return s2SUrl;
	}

	public void setS2SUrl(String s2SUrl) {
		this.s2SUrl = s2SUrl;
	}
}

