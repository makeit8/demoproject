package com.example.strategyfactory;

import com.example.util.UserType;

/**
 * @author sunpeng93
 * @description 黄金用户
 * @date 2019/12/29
 */
public class GoldStrategy implements Strategy {
    @Override
    public double compute(long money) {
        System.out.println("黄金会员，优惠100元");
        return money - 100;
    }

    @Override
    public int getType() {
        return UserType.GOLD_VIP.getCode();
    }
}
