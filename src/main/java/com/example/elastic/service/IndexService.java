package com.example.elastic.service;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class IndexService {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 创建索引
     * dynamic属性有三个值：true：默认，可以自动创建索引，插入数据字段不符合的话就创建新的索引。false：不自动创建索引，当插入数据不符合默认属性的时候，忽略新插入的不符合的字段的值 strict：精确的，不允许插入不符合默认属性的值，如果不符合，直接报错。
     * keyword：数据类型用来建立电子邮箱地址、姓名、邮政编码和标签等数据类型，不需要进行分词。可以被用来检索过滤、排序和聚合。keyword 类型字段只能用本身来进行检索。
     * text：Text 数据类型被用来索引长文本，这些文本会被分析，在建立索引前会将这些文本进行分词，转化为词的组合，建立索引。比如你配置了IK分词器，那么就会进行分词，搜索的时候会搜索分词来匹配这个text文档。但是：text 数据类型不能用来排序和聚合
     * 索引（Index）：相当于数据库，用于定义文档类型的存储；在同一个索引中，同一个字段只能定义一个数据类型；
     * 文档类型（Type）：相当于关系表，用于描述文档中的各个字段的定义；不同的文档类型，能够存储不同的字段，服务于不同的查询请求；
     * 文档（Document）：相当于关系表的数据行，存储数据的载体，包含一个或多个存有数据的字段；
     * 字段（Field）：文档的一个Key/Value对；
     * 词（Term）：表示文本中的一个单词；
     * 标记（Token）：表示在字段中出现的词，由该词的文本、偏移量（开始和结束）以及类型组成；
     */
    public boolean createIndex() {
        boolean isCreated = true;
        try {
            // 创建 Mapping
            XContentBuilder mapping = XContentFactory.jsonBuilder()
                    .startObject()
                        .field("dynamic", true)
                    .startObject("properties")
                    .startObject("name")
                        .field("type","text")
                    .startObject("fields")
                    .startObject("keyword")
                        .field("type","keyword")
                    .endObject()
                    .endObject()
                    .endObject()
                    .startObject("address")
                        .field("type","text")
                    .startObject("fields")
                    .startObject("keyword")
                        .field("type","keyword")
                    .endObject()
                    .endObject()
                    .endObject()
                    .startObject("remark")
                        .field("type","text")
                    .startObject("fields")
                    .startObject("keyword")
                        .field("type","keyword")
                    .endObject()
                    .endObject()
                    .endObject()
                    .startObject("age")
                        .field("type","integer")
                    .endObject()
                    .startObject("salary")
                        .field("type","float")
                    .endObject()
                    .startObject("birthDate")
                        .field("type","date")
                        .field("format", "yyyy-MM-dd")
                    .endObject()
                    .startObject("createTime")
                        .field("type","date")
                    .endObject()
                    .endObject()
                    .endObject();
            // 创建索引配置信息，配置
            Settings settings = Settings.builder()
                    .put("index.number_of_shards", 1)
                    .put("index.number_of_replicas", 0)
                    .build();
            // 新建创建索引请求对象，然后设置索引类型 和 mapping 与 index 配置
            CreateIndexRequest request = new CreateIndexRequest("mydlq-user", settings);
            request.mapping("doc", mapping);
            // RestHighLevelClient 执行创建索引
            CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
            // 判断是否创建成功
            isCreated = createIndexResponse.isAcknowledged();
            log.info("是否创建成功：{}", isCreated);
        } catch (IOException e) {
            log.error("", e);
        }
        return isCreated;
    }


    /**
     * 删除索引
     */
    public boolean deleteIndex() {
        boolean siDeleted = true;
        try {
            // 新建删除索引请求对象
            DeleteIndexRequest request = new DeleteIndexRequest("mydlq-user");
            // 执行删除索引
            AcknowledgedResponse acknowledgedResponse = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
            // 判断是否删除成功
            siDeleted = acknowledgedResponse.isAcknowledged();
            log.info("是否删除成功：{}", siDeleted);
        } catch (IOException e) {
            log.error("", e);
        }
        return siDeleted;
    }
}
