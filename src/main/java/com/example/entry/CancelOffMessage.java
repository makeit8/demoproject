package com.example.entry;

import java.util.List;

/**
 * @author sunpeng93
 * @description CancelOffMessage
 * @date 2020/1/15
 */
public class CancelOffMessage {
    private String orderId;
    private long num;
    private List<CancelOffCouponInfo> couponList;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public List<CancelOffCouponInfo> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<CancelOffCouponInfo> couponList) {
        this.couponList = couponList;
    }
}
