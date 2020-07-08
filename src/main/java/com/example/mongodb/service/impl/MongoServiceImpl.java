package com.example.mongodb.service.impl;

import com.example.entry.MongoEntity;
import com.example.mongodb.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * @author sunpeng93
 * @description mongodb CRUD服务
 * @date 2019/12/27
 */
@Service
public class MongoServiceImpl implements MongoService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insertEntity(MongoEntity entity) {
        mongoTemplate.save(entity);
    }

    @Override
    public MongoEntity findEntity(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        MongoEntity mongoEntity = mongoTemplate.findOne(query,MongoEntity.class);
        return mongoEntity;
    }

    @Override
    public MongoEntity findEntityById(Integer id) {
        Query query = new Query(Criteria.where("_id").is(id));
        MongoEntity mongoEntity = mongoTemplate.findOne(query,MongoEntity.class);
        return mongoEntity;
    }

    @Override
    public void updateEntity(MongoEntity entity) {
        Query query = new Query(Criteria.where("ad").is(entity.get_id()));
        Update update = new Update().set("age",entity.getAge()).set("name",entity.getName());
        mongoTemplate.updateFirst(query,update,MongoEntity.class);
    }

    @Override
    public void deleteEntity(Integer id) {
        Query query = new Query(Criteria.where("ad").is(id));
        mongoTemplate.remove(query,MongoEntity.class);
    }
}
