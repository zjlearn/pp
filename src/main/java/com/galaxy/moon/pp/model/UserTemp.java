package com.galaxy.moon.pp.model;

import java.math.BigDecimal;

/**
 * create by zhangjun1 on 2017/9/30
 */
public class UserTemp {
    private Long id;
    private String nickname; //昵称
    private String username; //账号
    private String mobile;
    private String email;

    private String password; //密码;
    private String salt;//加密密码的盐
    private String sex;
    private String idCard;  //身份证号
    private Integer age;
    private String birthPlace;  //籍贯
    private Integer marryStatus;    //婚姻状态

    private String ipsAccount;  //ips账户
    private Integer redPacketNum; //红包个数
    private BigDecimal availableRemain; //可用余额
    private BigDecimal frozenRemain; //可用余额

    private int status;  //用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.

    public UserTemp() {
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
        this.birthPlace = birthPlace;
    }

    public Integer getMarryStatus() {
        return marryStatus;
    }

    public void setMarryStatus(Integer marryStatus) {
        this.marryStatus = marryStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIpsAccount() {
        return ipsAccount;
    }

    public void setIpsAccount(String ipsAccount) {
        this.ipsAccount = ipsAccount;
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
}
