package com.example.abstracttest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version V1.0
 * @Description run
 * @Author sunpeng93
 * @Date 2020/7/8
 */
@RestController
@RequestMapping("/runController")
public class RunController {
    @Autowired
    private BoyRunC boyRunC;
    @Autowired
    private GirlRunC girlRunC;

    @GetMapping("/boyRun")
    public void getBoyRun(){
        boyRunC.runT();
    }
    @GetMapping("/girlRun")
    public void getGirlRun(){
        girlRunC.runT();
    }
}
