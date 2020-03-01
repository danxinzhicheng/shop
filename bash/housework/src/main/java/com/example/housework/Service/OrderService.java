package com.example.housework.Service;

import com.example.housework.mapper.OrderMapper;
import com.example.housework.message.OrderMessage;
import com.example.housework.pojo.Order;
import com.example.housework.util.SendMessage;
import com.example.housework.vo.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    SendMessage sendMessage;

    public Bean add(int sid,int uid,String address,String area,String name,String mobile){
        Bean<String> res = new Bean<>();
        Date activetime = new Date();
        Date failuretime = new Date(3);
        orderMapper.add(sid,uid,activetime,failuretime,address,area,name,mobile);
        OrderMessage order = new OrderMessage();
        order.setName(name);
        order.setTime(new Date());
        order.setAddress(address);
        order.setTel(mobile);
        sendMessage.send(order,mobile,1);
        res.setRespCode(0);
        res.setMessage("ok");
        return res;
    }

    public Bean list(int uid){
        Bean<List<Order>> res = new Bean<>();
        List<Order> list = orderMapper.list(uid);
        res.setRespCode(0);
        res.setMessage("ok");
        res.setData(list);
        return res;
    }
}
