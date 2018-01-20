package com.galaxy.moon.pp.model.status;

/**
 * create by zhangjun1 on 2018/1/20
 */
public enum UserStatusEnum {
    REGISTERED(1, "已注册"),
    AUTHENTICATED(2, "已实名认证"),
    NOT_AUTHENTICATE(4, "未实名认证"),
    LOCKED(8, "冻结");

    private final int value;
    private final String desc;

    UserStatusEnum(int value, String desc) {
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
