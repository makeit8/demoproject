package com.example.elastic.service;

import com.alibaba.fastjson.JSON;
import com.example.entry.Employee;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
@Slf4j
public class DocumentService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 增加文档信息
     * 字符串类型：keyword和text。（在5.0之后更改，原来为string）
     * 数值类型：字节（byte）、2字节（short）、4字节（integer）、8字节（long）、float、double；
     * 布尔类型：boolean，值是true或false；
     * 时间/日期类型：date，用于存储日期和时间；
     * 二进制类型：binary；
     * IP地址类型：ip，以字符串形式存储IPv4地址；
     * 特殊数据类型：token_count，用于存储索引的字数信息
     */
    public void addDocument() {
        try {
            // 创建索引请求对象
            IndexRequest indexRequest = new IndexRequest("mydlq-user", "doc", "3");
            // 创建员工信息
            Employee employee = new Employee();
            employee.setName("王五");
            employee.setAge(28);
            employee.setSalary(400l);
            employee.setAddress("北京市东城区");
            employee.setRemark("来自北京市的王五");
            employee.setCreateTime(new Date());
            employee.setBirthDate("1990-01-10");
            // 将对象转换为 byte 数组
            byte[] json = JSON.toJSONBytes(employee);
            // 设置文档内容
            indexRequest.source(json, XContentType.JSON);
            // 执行增加文档
            IndexResponse response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            log.info("创建状态：{}", response.status());
        } catch (Exception e) {
            log.error("", e);
        }
    }

    /**
     * 获取文档信息
     */
    public Employee getDocument() {
        Employee employee = new Employee();
        try {
            // 获取请求对象
            GetRequest getRequest = new GetRequest("mydlq-user", "doc", "2");
            // 获取文档信息
            GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
            // 将 JSON 转换成对象
            if (getResponse.isExists()) {
                employee = JSON.parseObject(getResponse.getSourceAsBytes(), Employee.class);
                log.info("员工信息：{}", employee);
            }
        } catch (IOException e) {
            log.error("", e);
        }
        return employee;
    }

    /**
     * 更新文档信息
     */
    public void updateDocument() {
        try {
            // 创建索引请求对象
            UpdateRequest updateRequest = new UpdateRequest("mydlq-user", "doc", "1");
            // 设置员工更新信息
            Employee employee = new Employee();
            employee.setSalary(200l);
            employee.setAddress("北京市海淀区");
            // 将对象转换为 byte 数组
            byte[] json = JSON.toJSONBytes(employee);
            // 设置更新文档内容
            updateRequest.doc(json, XContentType.JSON);
            // 执行更新文档
            UpdateResponse response = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
            log.info("创建状态：{}", response.status());
        } catch (Exception e) {
            log.error("", e);
        }
    }

    /**
     * 删除文档信息
     */
    public int deleteDocument() {
        DeleteResponse response = new DeleteResponse();
        try {
            // 创建删除请求对象
            DeleteRequest deleteRequest = new DeleteRequest("mydlq-user", "doc", "1");
            // 执行删除文档
            response = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
            log.info("删除状态：{}", response.status());
        } catch (IOException e) {
            log.error("", e);
        }
        return response.status().getStatus();
    }

}
