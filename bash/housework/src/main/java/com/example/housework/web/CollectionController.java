package com.example.housework.web;

import com.example.housework.Service.CollectionService;
import com.example.housework.vo.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollectionController {
    @Autowired
    CollectionService collectionService;

    @PostMapping("/collection/add/{uid}/{sid}")
    public Bean add(@PathVariable("uid") int uid, @PathVariable("sid") int sid){
        return collectionService.add(uid,sid);
    }

    @PostMapping("/collection/reduce/{uid}/{sid}")
    public Bean reduce(@PathVariable("uid") int uid, @PathVariable("sid") int sid){
        return collectionService.reduce(uid,sid);
    }

    @PostMapping("/collection/isCollection/{uid}/{sid}")
    public Bean isCollection(@PathVariable("uid") int uid, @PathVariable("sid") int sid){
        return collectionService.isCollection(uid,sid);
    }

    @PostMapping("/collection/list/{uid}")
    public Bean list(@PathVariable("uid") int uid){
        return collectionService.list(uid);
    }
}
