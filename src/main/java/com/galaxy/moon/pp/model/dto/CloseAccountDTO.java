package com.galaxy.moon.pp.model.dto;

/**
 * 销户的DTO模型
 */
public class CloseAccountDTO {

    private String userName;
    private String ipsAcctNo;
    private String webUrl;
    private String s2SUrl;

    public CloseAccountDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIpsAcctNo() {
        return ipsAcctNo;
    }

    public void setIpsAcctNo(String ipsAcctNo) {
        this.ipsAcctNo = ipsAcctNo;
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
}
