package com.galaxy.moon.pp.model;

public enum IPSFeeTypeEnum {
    Merchant("1", "个人"),
    platform("2", "企业");

    public final String type;
    public final String desc;

    IPSFeeTypeEnum(String type, String desc) {
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
