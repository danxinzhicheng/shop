package com.example.housework.web;

import com.example.housework.Service.UserService;
import com.example.housework.vo.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user/register/{name}/{password}/{ve}")
    public Bean register(@PathVariable("name") String name,@PathVariable("password") String password,@PathVariable("ve") String ve){
        return userService.register(name,password,ve);
    };

    @PostMapping("/user/login/{name}/{password}")
    public Bean login(@PathVariable("name") String name,@PathVariable("password") String password){
        return userService.login(name,password);
    }

    @PostMapping("/user/uid/{name}")
    public Bean uid(@PathVariable("name") String name){
        return userService.uid(name);
    }

    @PostMapping("/user/getvericode/{tel}")
    public Bean getVeriCode(@PathVariable("tel") String tel){
        return userService.getVeriCode(tel);
    }
}
