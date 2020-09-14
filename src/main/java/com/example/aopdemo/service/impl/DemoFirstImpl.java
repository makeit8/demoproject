package com.example.aopdemo.service.impl;

import com.example.aopdemo.service.DemoAopAnnotation;
import com.example.aopdemo.service.DemoFirstService;
import com.example.entry.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0
 * @Description first
 * @Author sunpeng93
 * @Date 2020/7/13
 */
@Service("demoFirstImpl")
public class DemoFirstImpl implements DemoFirstService {
    @Override
    @DemoAopAnnotation
    public String getRealName(Person person) {
        return person.getName();
    }
}
