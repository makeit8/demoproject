package com.example.elastic.service;

import com.alibaba.fastjson.JSON;
import com.example.entry.Employee;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class QueryService {
    @Autowired
    private RestHighLevelClient restHighLevelClient;


    /**
     * 精确查询
     */
    public List<Employee> termQuery() {
        // 构建查询条件（注意：termQuery 支持多种格式查询，如 boolean、int、double、string 等，这里使用的是 string 的查询）
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termQuery("name.keyword", "张三"));
        return handleQuery(searchSourceBuilder);
    }

    /**
     * 多个内容在一个字段中进行查询
     */
    public List<Employee> termsQuery() {
        // 构建查询条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termsQuery("address", "北京市朝阳区", "北京市昌平区"));
        return handleQuery(searchSourceBuilder);
    }

    /**
     * 匹配查询数据
     */
    public List<Employee> matchQuery() {
        // 构建查询条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("address", "北京市"));
        return handleQuery(searchSourceBuilder);
    }


    private List<Employee> handleQuery(SearchSourceBuilder searchSourceBuilder){
        List<Employee> employees = new ArrayList<>();
        try {
            SearchRequest searchRequest = new SearchRequest("mydlq-user");
            searchRequest.source(searchSourceBuilder);
            // 执行查询，然后处理响应结果
            SearchResponse searchResponse = null;
            searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 根据状态和数据条数验证是否返回了数据
            if (RestStatus.OK.equals(searchResponse.status()) && searchResponse.getHits().totalHits > 0) {
                SearchHits hits = searchResponse.getHits();
                for (SearchHit hit : hits) {
                    // 将 JSON 转换成对象
                    Employee employee = JSON.parseObject(hit.getSourceAsString(), Employee.class);
                    employees.add(employee);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }


}
