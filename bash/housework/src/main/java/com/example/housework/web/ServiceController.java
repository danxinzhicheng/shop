package com.example.housework.web;

import com.example.housework.Service.ServiceService;
import com.example.housework.vo.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
    @Autowired
    ServiceService serviceService;

    @GetMapping("/service/list/{type}")
    public Bean list(@PathVariable("type") String type){
        return serviceService.list(type);
    }

    @GetMapping("/service/recommend")
    public Bean list(){
        return serviceService.recommend();
    }

    @GetMapping("/service/detail/{id}")
    public Bean detail(@PathVariable("id") int id){
        return serviceService.detail(id);
    }


}
