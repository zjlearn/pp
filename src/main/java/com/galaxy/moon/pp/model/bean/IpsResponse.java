package com.galaxy.moon.pp.model.bean;


/**
 * create by zhangjun1 on 2017/12/3
 */
public class IpsResponse {
    public String resultCode;
    public  String resultMsg;
    public String sign;
    public String response;
    public String merchantID;

    public IpsResponse() {
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(String merchantID) {
        this.merchantID = merchantID;
    }

    @Override
    public String toString() {
        return "IpsResponse{" +
                "resultCode='" + resultCode + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", sign='" + sign + '\'' +
                ", response='" + response + '\'' +
                ", merchantID='" + merchantID + '\'' +
                '}';
    }
}