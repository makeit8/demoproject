package com.example.aopdemo.controller;

import com.example.aopdemo.service.DemoFirstService;
import com.example.entry.Person;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @version V1.0
 * @Description aop
 * @Author sunpeng93
 * @Date 2020/7/13
 */
@RequestMapping("/aopController")
@RestController
public class AopController {
    @Resource(name = "demoFirstImpl")
    private DemoFirstService demoFirstImpl;

    @PostMapping("/getRealName")
    public String getRealName(@RequestBody Person person){
        return demoFirstImpl.getRealName(person);
    }
}
