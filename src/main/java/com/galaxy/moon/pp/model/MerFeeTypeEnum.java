package com.galaxy.moon.pp.model;

public enum MerFeeTypeEnum {
    INNER_PAY("1","内扣"),
    OUTER_PAY("2","外扣");

    public final String type;
    public final String desc;

    MerFeeTypeEnum(String type, String desc) {
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
