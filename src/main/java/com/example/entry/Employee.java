package com.example.entry;

import lombok.Data;

import java.util.Date;

@Data
public class Employee {
    private String name;
    private Integer age;
    private String address;
    private String remark;
    private Date createTime;
    private String birthDate;
    private Long salary;
}
