package com.example.housework.web;

import com.example.housework.Service.OrderService;
import com.example.housework.vo.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order/add/{sid}/{uid}/{address}/{area}/{name}/{mobile}")
    public Bean add(@PathVariable("sid") int sid,@PathVariable("uid") int uid,@PathVariable("address") String address,@PathVariable("area") String area,@PathVariable("name") String name,@PathVariable("mobile") String mobile){
        return orderService.add(sid,uid,address,area,name,mobile);
    }

    @GetMapping("/order/list/{uid}")
    public Bean list(@PathVariable("uid") int uid){
        return orderService.list(uid);
    }
}
