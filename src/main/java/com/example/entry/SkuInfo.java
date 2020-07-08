package com.example.entry;

/**
 * @author sunpeng93
 * @description SkuInfo
 * @date 2020/1/15
 */
public class SkuInfo {
    /**
     * skuId
     */
    private String skuId;
    /**
     * 单价
     */
    private String skuPrice;
    /**
     * 数量
     */
    private Long skuNumber;

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(String skuPrice) {
        this.skuPrice = skuPrice;
    }

    public Long getSkuNumber() {
        return skuNumber;
    }

    public void setSkuNumber(Long skuNumber) {
        this.skuNumber = skuNumber;
    }
}
