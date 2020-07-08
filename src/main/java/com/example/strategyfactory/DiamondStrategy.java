package com.example.strategyfactory;

import com.example.util.UserType;

/**
 * @author sunpeng93
 * @description 钻石会员
 * @date 2019/12/29
 */
public class DiamondStrategy implements Strategy {
    @Override
    public double compute(long money) {
        System.out.println("钻石会员，优惠200元");
        return 0;
    }

    @Override
    public int getType() {
        return UserType.DIAMOND_VIP.getCode();
    }
}
