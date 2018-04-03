package com.galaxy.moon.pp.model;

public enum RateTypeEnum {
    FIXED("1", "固定利率"),
    FLOAT("2", "浮动利率");
    public final String type;
    public final String desc;

    RateTypeEnum(String type, String desc) {
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
