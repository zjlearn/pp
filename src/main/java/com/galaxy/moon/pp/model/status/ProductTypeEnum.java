package com.galaxy.moon.pp.model.status;

/**
 * create by zhangjun1 on 2018/1/20
 */
public enum ProductTypeEnum {
    CAR_LOAN(1, "车贷"),
    Mortgage(2, "房贷"),
    BUSINESS_LOAN(4, "企业贷");

    private final int  value;
    private final String desc;

    ProductTypeEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
