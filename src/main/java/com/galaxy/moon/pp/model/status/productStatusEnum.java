package com.galaxy.moon.pp.model.status;

/**
 * create by zhangjun1 on 2018/1/20
 */
public enum productStatusEnum {
    INVESTING(1, "投资中"),
    FINISHED_INVEST(2, "已满标"),
    PAY_BACK(4, "还款中");

    private final int  value;
    private final String desc;

    productStatusEnum(int value, String desc) {
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
