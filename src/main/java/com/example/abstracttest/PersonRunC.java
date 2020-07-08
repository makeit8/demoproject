package com.example.abstracttest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @version V1.0
 * @Description run
 * @Author sunpeng93
 * @Date 2020/7/8
 */
@Slf4j
@Service("personRunc")
public class PersonRunC implements RunC{
    @Override
    public void runT(){
        log.info("this is person run");
        System.out.println("this is person run");
    }
}
