package com.example.mongodb.controller;

import com.example.entry.MongoEntity;
import com.example.mongodb.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunpeng93
 * @description mongodb CRUD服务
 * @date 2019/12/27
 */
@RestController
@RequestMapping("/mongodbController")
public class MongoController {
    @Autowired
    private MongoService mongoService;

    @RequestMapping("/insertEntity")
    public String insertEntity(){
        MongoEntity entity = new MongoEntity();
        entity.set_id(Integer.valueOf(3));
        entity.setAge(Integer.valueOf(3));
        entity.setName("enzo");
        mongoService.insertEntity(entity);
        return String.format("record id=%s,name=%s,age=%s",entity.get_id(),entity.getName(),entity.getAge());
    }

    @RequestMapping("/findEntity")
    public MongoEntity findEntity(@RequestParam(name = "name",required = true)String name){
        MongoEntity mongoEntity = mongoService.findEntity(name);
        return mongoEntity;
    }

    @RequestMapping("/findEntityById")
    public MongoEntity findEntityById(@RequestParam(name = "id",required = true)Integer id){
        MongoEntity mongoEntity = mongoService.findEntityById(id);
        return mongoEntity;
    }

    @RequestMapping("/updateEntity")
    public void updateEntity(){
        MongoEntity entity = new MongoEntity();
        entity.set_id(1);
        entity.setAge(2);
        entity.setName("enzoo");
        mongoService.updateEntity(entity);
    }

    @RequestMapping("/deleteEntity")
    public void deleteEntity(@RequestParam(name = "id")Integer id){
        mongoService.deleteEntity(id);
    }

}
