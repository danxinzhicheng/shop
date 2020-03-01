package com.example.housework.Service;

import com.example.housework.mapper.UserMapper;
import com.example.housework.message.Code;
import com.example.housework.util.SendMessage;
import com.example.housework.vo.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisService redisService;
    @Autowired
    SendMessage sendMessage;
    //注册
    public Bean<String> register(String name,String password,String ve){
        Bean<String> res = new Bean<>();
        if(!userMapper.isExsit(name).isEmpty()){
            res.setRespCode(1);
            res.setMessage("用户已存在");
            return res;
        }
        String veriCode = (String)redisService.get(name);
        if(veriCode!= null && veriCode.equals(ve)){
            System.out.println("code: "+veriCode);
            res.setRespCode(1);
            res.setMessage("验证码不正确");
            return res;
        }
        if(!userMapper.register(name,password)){
            res.setRespCode(1);
            res.setMessage("注册失败");
        }
        res.setRespCode(0);
        res.setMessage("注册成功");
        return res;
    }

    //登录
    public Bean<String> login(String name,String password){
        Bean<String> res = new Bean<String>();
        if(!userMapper.login(name,password).isEmpty()){
            res.setRespCode(0);
            res.setMessage("登录成功");
            return res;
        }
        res.setRespCode(1);
        res.setMessage("没有该账户");
        return res;
    }

    public Bean uid(String name){
        Bean<Integer> res = new Bean<>();
        res.setRespCode(0);
        res.setMessage("ok");
        res.setData(userMapper.uid(name));
        return res;
    }

    //获取验证码
    public Bean<String> getVeriCode(String tel){
        Bean<String> res = new Bean<>();
        res.setRespCode(0);
        res.setMessage("ok");
        StringBuilder s = sendMessage.code();
        redisService.set(tel,s.toString());
        Code code = new Code();
        code.setCode(s.toString());
        sendMessage.send(code,tel,0);
        res.setData("验证码获取成功");
        return res;
    }
}
