package com.example.test;

import com.alibaba.fastjson.JSONObject;
import com.example.entry.CancelOffCouponInfo;
import com.example.entry.CancelOffMessage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author sunpeng93
 * @description 对象转json
 * @date 2020/1/15
 */
public class StrToJsonTest {
    public static void main(String[] args) {
        CancelOffMessage cancelOffMessage = new CancelOffMessage();
        cancelOffMessage.setOrderId("109702471273");
        cancelOffMessage.setNum(1);
        List<CancelOffCouponInfo> couponList = new ArrayList<>();
        CancelOffCouponInfo cancelOffCouponInfo = new CancelOffCouponInfo();
        cancelOffCouponInfo.setCouponId(89320);
        cancelOffCouponInfo.setCancelOffAmount(500);
        cancelOffCouponInfo.setCancelTime(new Date("Tue Jan 14 20:28:19 CST 2020"));
        cancelOffCouponInfo.setCouponType(0);
        cancelOffCouponInfo.setStoreId(23816189);
        cancelOffCouponInfo.setBid(100000000002061L);
        cancelOffCouponInfo.setSkuList(null);
        cancelOffCouponInfo.setId("89320_19029346");
        couponList.add(cancelOffCouponInfo);
        cancelOffMessage.setCouponList(couponList);
        System.out.println(JSONObject.toJSONString(cancelOffMessage));
    }
}
