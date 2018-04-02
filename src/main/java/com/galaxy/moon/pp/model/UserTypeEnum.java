package com.galaxy.moon.pp.model;

public enum UserTypeEnum {
    PERSON("1", "个人"),
    COMPANY("2", "企业");
    public final String type;
    public final String desc;

    UserTypeEnum(String type, String desc) {
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
