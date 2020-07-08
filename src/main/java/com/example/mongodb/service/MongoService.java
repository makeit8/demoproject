package com.example.mongodb.service;

import com.example.entry.MongoEntity;
import org.springframework.stereotype.Component;

/**
 * @author sunpeng93
 * @description mongodb CRUD服务
 * @date 2019/12/27
 */
@Component
public interface MongoService {
    public void insertEntity(MongoEntity entity);
    public MongoEntity findEntity(String name);
    public MongoEntity findEntityById(Integer id);
    public void updateEntity(MongoEntity entity);
    public void deleteEntity(Integer id);
}
