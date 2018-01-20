package com.galaxy.moon.pp.model.vo;

import com.galaxy.moon.pp.model.User;

/**
 * create by zhangjun1 on 2018/1/20
 */
public class RegisterUserVO {
    private String mobileNo;
    private String password;
    private String inviteCode;

    public RegisterUserVO() {
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

    @Override
    public String toString() {
        return "RegisterUserVO{" +
                "mobileNo='" + mobileNo + '\'' +
                ", password='" + password + '\'' +
                ", inviteCode='" + inviteCode + '\'' +
                '}';
    }
}
