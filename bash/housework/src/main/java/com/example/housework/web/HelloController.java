package com.example.housework.web;

import com.example.housework.Service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    RedisService redisService;

    @RequestMapping("Hello")
    public String Hello() {
        redisService.set("name","hello");
        String name = redisService.get("name").toString();
        System.out.println(name);
        return "date";
    }
}
