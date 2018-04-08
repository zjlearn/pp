package com.galaxy.moon.pp.model;

/**
 *红包的状态枚举类
 */
public enum RedPacketStatusEnum {
    UN_USED(1, "固定利率"),
    USED(2, "浮动利率"),
    EXPIRE(3, "过期");
    public final int status;
    public final String desc;

    RedPacketStatusEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
