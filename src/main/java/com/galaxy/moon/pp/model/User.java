package com.galaxy.moon.pp.model;

import java.math.BigDecimal;

public class User {
    private Long id;

    private String userName;

    private String nickName;

    private String mobile;

    private String emial;

    private String password;

    private Byte sex;

    private String idCard;

    private Integer age;

    private String birthPlace;

    private Byte marryStatus;

    private Byte userType;

    private String ipsAccount;

    private Integer redPacketNum;

    private BigDecimal availableRemain;

    private BigDecimal frozenRemain;

    private Integer userRole;

    private Byte status;

    private Long createTime;

    private Long updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial == null ? null : emial.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace == null ? null : birthPlace.trim();
    }

    public Byte getMarryStatus() {
        return marryStatus;
    }

    public void setMarryStatus(Byte marryStatus) {
        this.marryStatus = marryStatus;
    }

    public Byte getUserType() {
        return userType;
    }

    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    public String getIpsAccount() {
        return ipsAccount;
    }

    public void setIpsAccount(String ipsAccount) {
        this.ipsAccount = ipsAccount == null ? null : ipsAccount.trim();
    }

    public Integer getRedPacketNum() {
        return redPacketNum;
    }

    public void setRedPacketNum(Integer redPacketNum) {
        this.redPacketNum = redPacketNum;
    }

    public BigDecimal getAvailableRemain() {
        return availableRemain;
    }

    public void setAvailableRemain(BigDecimal availableRemain) {
        this.availableRemain = availableRemain;
    }

    public BigDecimal getFrozenRemain() {
        return frozenRemain;
    }

    public void setFrozenRemain(BigDecimal frozenRemain) {
        this.frozenRemain = frozenRemain;
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

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }
}