package com.galaxy.moon.pp.model.status;

/**
 * create by zhangjun1 on 2018/1/20
 */
public enum LoanTypeEnum {
    AUTO(1, "自动投资"),
    MANUAL(2, "手动投资");

    private final int  value;
    private final String desc;

    LoanTypeEnum(int value, String desc) {
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
