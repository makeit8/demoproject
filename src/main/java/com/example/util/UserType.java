package com.example.util;

public enum UserType {
    ORDINARY_VIP(0,"普通会员"),
    SLIVER_VIP(10,"白银会员，优惠50元"),
    GOLD_VIP(20,"黄金会员，优惠100元"),
    DIAMOND_VIP(30,"钻石会员，优惠150元");

    private Integer code;
    private String desc;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    UserType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
