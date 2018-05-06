package com.galaxy.moon.pp.model.vo;

import com.galaxy.moon.pp.model.bean.User;

/**
 * create by zhangjun1 on 2018/1/20
 */
public class UserRegisterVO {
    private String mobileNo;
    private String password;
    private String inviteCode;
    private Integer userRole;
    private Integer userType;


    public UserRegisterVO() {
    }

    public User toUser(){
        User u= new User();
        u.setMobile(this.mobileNo);
        u.setPassword(password);
        return u;
    }
    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "UserRegisterVO{" +
                "mobileNo='" + mobileNo + '\'' +
                ", password='" + password + '\'' +
                ", inviteCode='" + inviteCode + '\'' +
                ", userRole=" + userRole +
                ", userType=" + userType +
                '}';
    }
}
