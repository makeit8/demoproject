package com.example.aopdemo.service.impl;

import com.example.aopdemo.service.DemoSecondService;
import com.example.entry.Person;
import org.springframework.stereotype.Service;

/**
 * @version V1.0
 * @Description second
 * @Author sunpeng93
 * @Date 2020/7/13
 */
@Service("demoSecondImpl")
public class DemoSecondImpl implements DemoSecondService {
    @Override
    public String getRealName(Person person) {
        return person.getName() + "second";
    }
}
