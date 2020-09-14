package com.example.reflectdemo;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @version V1.0
 * @Description reflect
 * @Author sunpeng93
 * @Date 2020/7/20
 */
public class ReflectDemo {
    private static final Map<String,String> methodMap = new HashMap<>();
    private static final String REFLECTB = "com.example.reflectdemo.ReflectB";
    static {
        methodMap.put("getDescA","getDescB");
    }
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName(REFLECTB);

            Method methodB = clazz.getMethod(methodMap.get("getDescA"));

            String result = (String)methodB.invoke(clazz.newInstance(),null);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
