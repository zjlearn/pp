package com.galaxy.moon.pp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * create by zhangjun1 on 2018/3/29
 * 配置
 */
@Configuration
public class IPSConfig {

    @Value("${ips.encryptKey}")
    private String encryptKey;
    @Value("${ips.iv}")
    private String iv ;
    @Value("${ips.mdstr}")
    private String mdstr;
    @Value("${ips.merchantID}")
    private String merchantID;
    @Value("${ips.serverAdderss}")
    private String ipsServerAdderss;

    public String getEncryptKey() {
        return encryptKey;
    }

    public String getIv() {
        return iv;
    }

    public String getMdstr() {
        return mdstr;
    }

    public String getMerchantID() {
        return merchantID;
    }

    public String getIpsServerAdderss() {
        return ipsServerAdderss;
    }
}
