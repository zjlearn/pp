package com.galaxy.moon.pp.model;

public enum TradeStatusEnum {
    INIT(-1, "初始化"),
    FAILED(0, "失败"),
    SCUESS(1, "成功"),
    ON(2, "处理中"),
    CANCEL(3, "已取消");

    public final int status;
    public final String desc;

    TradeStatusEnum(int status, String desc) {
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
