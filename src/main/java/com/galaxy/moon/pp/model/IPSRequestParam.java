package com.galaxy.moon.pp.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * create by zhangjun1 on 2017/12/3
 */
@Component
public class IPSRequestParam {

    @Value("${ipsServerAdderss}")
    public String TestServerAdderss;

    @Value("${merchantID}")
    public static String merchantID = "";
}
