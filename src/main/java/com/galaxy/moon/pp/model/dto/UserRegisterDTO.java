package com.galaxy.moon.pp.model.dto;


/*
 * 这个是用户添加的请求报文
 */
public class UserRegisterDTO  {

    public String userName;
    public String merBillNo;
    public String realName;
    public String bizType;
    public String mobileNo;
    public String enterName;
    public String merDate;
    public String userType;
    public String webUrl;
    public String orgCode;
    public String isAssureCom;
    public String s2SUrl;
    public String identNo;
    private String userRole;

    public UserRegisterDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMerBillNo() {
        return merBillNo;
    }

    public void setMerBillNo(String merBillNo) {
        this.merBillNo = merBillNo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEnterName() {
        return enterName;
    }

    public void setEnterName(String enterName) {
        this.enterName = enterName;
    }

    public String getMerDate() {
        return merDate;
    }

    public void setMerDate(String merDate) {
        this.merDate = merDate;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getIsAssureCom() {
        return isAssureCom;
    }

    public void setIsAssureCom(String isAssureCom) {
        this.isAssureCom = isAssureCom;
    }

    public String getS2SUrl() {
        return s2SUrl;
    }

    public void setS2SUrl(String s2SUrl) {
        this.s2SUrl = s2SUrl;
    }

    public String getIdentNo() {
        return identNo;
    }

    public void setIdentNo(String identNo) {
        this.identNo = identNo;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
