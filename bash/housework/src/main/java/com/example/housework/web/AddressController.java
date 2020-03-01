package com.example.housework.web;

import com.example.housework.Service.AddressService;
import com.example.housework.vo.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/address/add/{uid}/{name}/{mobile}/{addressName}/{area}/{default}")
    public Bean add(@PathVariable("uid") int uid,@PathVariable("name") String name,@PathVariable("mobile") String mobile,@PathVariable("addressName") String addressName,@PathVariable("area") String area,@PathVariable("default") boolean defa){
        return addressService.add(addressName,area,name,mobile,uid,defa);
    }

    @GetMapping("/address/list/{uid}")
    public Bean list(@PathVariable("uid") int uid){
        return addressService.list(uid);
    }

    @PostMapping("/address/update/{id}/{uid}/{name}/{mobile}/{addressName}/{area}/{default}")
    public Bean update(@PathVariable("id") int id,@PathVariable("uid") int uid,@PathVariable("name") String name,@PathVariable("mobile") String mobile,@PathVariable("addressName") String addressName,@PathVariable("area") String area,@PathVariable("default") boolean defa){
        return addressService.update(id,addressName,area,name,mobile,uid,defa);
    }
}
