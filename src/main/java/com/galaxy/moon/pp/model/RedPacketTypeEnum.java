package com.galaxy.moon.pp.model;

public enum RedPacketTypeEnum {
    CASH_PACKET("0", "现金红包"),
    COUPON_PACKET("1", "抵用券红包");
    public final String type;
    public final String desc;

    RedPacketTypeEnum(String type, String desc) {
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
