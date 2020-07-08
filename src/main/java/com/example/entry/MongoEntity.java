package com.example.entry;

import org.springframework.stereotype.Component;

/**
 * @author sunpeng93
 * @description MongoEntity
 * @date 2019/12/27
 */
@Component
public class MongoEntity {
    private Integer _id;
    private Integer age;
    private String name;

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
