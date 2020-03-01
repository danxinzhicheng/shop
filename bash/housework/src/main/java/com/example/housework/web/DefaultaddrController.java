package com.example.housework.web;

import com.example.housework.Service.DefalutaddrService;
import com.example.housework.vo.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultaddrController {

    @Autowired
    DefalutaddrService defalutaddrService;

    @PostMapping("/defaulraddr/add/{aid}/{uid}")
    public Bean add(@PathVariable("aid") int aid,@PathVariable("uid") int uid){
        return defalutaddrService.add(aid,uid);
    }

    @GetMapping("/defaulraddr/check/{uid}")
    public Bean check(@PathVariable("uid") int uid){
        return defalutaddrService.check(uid);
    }

    @PostMapping("/defaulraddr/detail/{uid}")
    public Bean detail(@PathVariable("uid") int uid){
        return defalutaddrService.detail(uid);
    }
}
