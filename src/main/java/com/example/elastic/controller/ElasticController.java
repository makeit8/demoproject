package com.example.elastic.controller;

import com.example.elastic.service.DocumentService;
import com.example.elastic.service.IndexService;
import com.example.elastic.service.QueryService;
import com.example.entry.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/elastic")
public class ElasticController {
    @Autowired
    private IndexService indexService;
    @Autowired
    private DocumentService documentService;
    @Autowired
    private QueryService queryService;

    @GetMapping("/createIndex")
    public String createIndex(){
        boolean isCreate = indexService.createIndex();

        return isCreate ? "创建成功" : "创建失败";
    }

    @GetMapping("/deleteIndex")
    public String deleteIndex(){
        boolean isDel = indexService.deleteIndex();
        return isDel ? "删除成功" : "删除失败";
    }

    @GetMapping("/addDocument")
    public void addDocument(){
        documentService.addDocument();
    }

    @GetMapping("/getDocument")
    public Employee getDocument(){
        return documentService.getDocument();
    }

    @GetMapping("/updateDocument")
    public void updateDocument(){
        documentService.updateDocument();
    }

    @GetMapping("/deleteDocument")
    public int deleteDocument(){
        return documentService.deleteDocument();
    }

    @GetMapping("/termQuery")
    public List<Employee> termQuery(){
        return queryService.termQuery();
    }

    @GetMapping("/termsQuery")
    public List<Employee> termsQuery(){
        return queryService.termsQuery();
    }

    @GetMapping("/matchQuery")
    public List<Employee> matchQuery(){
        return queryService.matchQuery();
    }

}
