package com.example.strategyfactory;

/**
 * @author sunpeng93
 * @description 普通会员
 * @date 2019/12/29
 */
public class OrdinaryStrategy implements Strategy{
    @Override
    public double compute(long money) {
        System.out.println("普通会员");
        return money;
    }

    @Override
    public int getType() {
        return 0;
    }
}
