package com.galaxy.moon.pp.model.status;

/**
 * create by zhangjun1 on 2018/1/20
 * 表示借款的状态枚举类型
 */
public enum LoanStatusEnum {
    TO_AUDIT(1, "待审核"),
    AUDITING(2, "审核中"),
    APPROVED(4, "已批准"),
    REJECTED(8, "已拒绝");

    private final int  value;
    private final String desc;

    LoanStatusEnum(int value, String desc) {
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
