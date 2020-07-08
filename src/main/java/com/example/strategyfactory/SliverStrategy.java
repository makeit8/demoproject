package com.example.strategyfactory;

import com.example.util.UserType;

/**
 * @author sunpeng93
 * @description 白银会员
 * @date 2019/12/29
 */
public class SliverStrategy implements Strategy {
    @Override
    public double compute(long money) {
        System.out.println("白银会员，优惠50元");
        return money - 50;
    }

    @Override
    public int getType() {
        return UserType.SLIVER_VIP.getCode();
    }
}
