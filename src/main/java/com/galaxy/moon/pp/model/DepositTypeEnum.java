package com.galaxy.moon.pp.model;

/**
 *
 */
public enum DepositTypeEnum {

    ORIGIN("1", "普通充值"),
    REPAY("2", "还款充值");

    public final String type;
    public final String desc;

    DepositTypeEnum(String type, String desc) {
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
