package com.galaxy.moon.pp.model.dto;


public class CommonQueryDTO  {

    public String merBillNo;
    public String queryType;
    public String ipsAcctNo;

    public CommonQueryDTO() {
    }

    public String getMerBillNo() {
        return merBillNo;
    }

    public void setMerBillNo(String merBillNo) {
        this.merBillNo = merBillNo;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getIpsAcctNo() {
        return ipsAcctNo;
    }

    public void setIpsAcctNo(String ipsAcctNo) {
        this.ipsAcctNo = ipsAcctNo;
    }
}
