package com.galaxy.moon.pp.model.dto;

public class DepositDTO {

    public String merBillNo;
    public String merDate;
    public String depositType;
    public String channelType;
    public String bankCode;
    public String userType;
    public String ipsAcctNo;
    public Double trdAmt;
    public String ipsFeeType;
    public Double merFee;
    public String taker;
    public String merFeeType;
    public String webUrl;
    public String s2SUrl;

    public DepositDTO() {
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

    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getIpsAcctNo() {
        return ipsAcctNo;
    }

    public void setIpsAcctNo(String ipsAcctNo) {
        this.ipsAcctNo = ipsAcctNo;
    }

    public String getIpsFeeType() {
        return ipsFeeType;
    }

    public void setIpsFeeType(String ipsFeeType) {
        this.ipsFeeType = ipsFeeType;
    }


    public String getTaker() {
        return taker;
    }

    public void setTaker(String taker) {
        this.taker = taker;
    }

    public String getMerFeeType() {
        return merFeeType;
    }

    public void setMerFeeType(String merFeeType) {
        this.merFeeType = merFeeType;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getS2SUrl() {
        return s2SUrl;
    }

    public void setS2SUrl(String s2SUrl) {
        this.s2SUrl = s2SUrl;
    }

    public Double getTrdAmt() {
        return trdAmt;
    }

    public void setTrdAmt(Double trdAmt) {
        this.trdAmt = trdAmt;
    }

    public Double getMerFee() {
        return merFee;
    }

    public void setMerFee(Double merFee) {
        this.merFee = merFee;
    }
}
