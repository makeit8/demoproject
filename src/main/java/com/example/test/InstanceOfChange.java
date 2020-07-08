package com.example.test;

import com.example.entry.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunpeng93
 * @description 强转测试
 * @date 2019/12/23
 */
public class InstanceOfChange {
    public static void main(String[] args) throws ClassNotFoundException {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1,"1"));
        list.add(new Person(2,"2"));

        Object o = list.get(0);
        if(o instanceof Person){
            System.out.println((Person)o);
        }
    }
}
