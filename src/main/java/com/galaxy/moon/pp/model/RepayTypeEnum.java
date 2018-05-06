package com.galaxy.moon.pp.model;

/**
 * create by zhangjun1 on 2018/5/5
 * 还款类型的枚举值
 */
public enum RepayTypeEnum {
    INTEREST_FIRST(0, "先息后本"),
    AVERAGE_CAPITAL_INTEREST(1, "等额本息");

    public final int type;
    public final String desc;

    RepayTypeEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
