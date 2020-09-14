package com.example.lombookbean;

import lombok.Data;

import java.io.Serializable;

/**
 * @version V1.0
 * @Description ren
 * @Author sunpeng93
 * @Date 2020/8/20
 */
@Data
public class Person implements Serializable {
    private Integer age;
    private Integer gender;
    private String name;
}
