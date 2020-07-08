package com.example.entry;

import java.util.Date;
import java.util.List;

/**
 * @author sunpeng93
 * @description CancelOffCouponInfo
 * @date 2020/1/15
 */
public class CancelOffCouponInfo {
    private long couponId ;//门店券Id
    private long cancelOffAmount;//核销金额
    private int couponType;//门店券类型
    private Date cancelTime;//核销时间
    private long bid;
    private long storeId;
    private List<SkuInfo> skuList;
    private String id;

    public long getCouponId() {
        return couponId;
    }

    public void setCouponId(long couponId) {
        this.couponId = couponId;
    }

    public long getCancelOffAmount() {
        return cancelOffAmount;
    }

    public void setCancelOffAmount(long cancelOffAmount) {
        this.cancelOffAmount = cancelOffAmount;
    }

    public int getCouponType() {
        return couponType;
    }

    public void setCouponType(int couponType) {
        this.couponType = couponType;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public long getBid() {
        return bid;
    }

    public void setBid(long bid) {
        this.bid = bid;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public List<SkuInfo> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<SkuInfo> skuList) {
        this.skuList = skuList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
