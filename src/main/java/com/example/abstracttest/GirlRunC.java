package com.example.abstracttest;

import org.springframework.stereotype.Service;

/**
 * @version V1.0
 * @Description run
 * @Author sunpeng93
 * @Date 2020/7/8
 */
@Service("girlRunc")
public class GirlRunC extends PersonRunC {
    @Override
    public void runT() {
        System.out.println("girl run");
    }
}
