package com.galaxy.moon.pp.model;

/**
 * create by zhangjun1 on 2018/4/2
 */
public enum ChannelTypeEnum {
    PERSON_ONLINE_BANK("1","个人网银"),
    COMPANY_ONLINE_BANK("2","企业网银");

    public final String type;
    public final String desc;

    ChannelTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
