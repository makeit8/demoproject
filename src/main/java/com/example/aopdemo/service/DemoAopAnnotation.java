package com.example.aopdemo.service;

import java.lang.annotation.*;

/**
 * @version V1.0
 * @Description aop
 * @Author sunpeng93
 * @Date 2020/7/13
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DemoAopAnnotation {
}
