package com.example.abstracttest;

import org.springframework.stereotype.Service;

/**
 * @version V1.0
 * @Description run
 * @Author sunpeng93
 * @Date 2020/7/8
 */
@Service("personRunc")
public class PersonRunC implements RunC{
    @Override
    public void runT(){
        System.out.println("this is person run");
    }
}
