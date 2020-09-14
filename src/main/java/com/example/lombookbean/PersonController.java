package com.example.lombookbean;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version V1.0
 * @Description c
 * @Author sunpeng93
 * @Date 2020/8/20
 */
@RestController
@RequestMapping("/personController")
public class PersonController {

    @PostMapping("/changePerson")
    public void changePerson(@RequestBody Person person){
        System.out.println(person.toString());
    }
}
