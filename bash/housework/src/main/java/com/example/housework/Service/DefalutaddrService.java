package com.example.housework.Service;

import com.example.housework.mapper.DefaultaddrMapper;
import com.example.housework.pojo.Defaultaddr;
import com.example.housework.vo.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefalutaddrService {

    @Autowired
    DefaultaddrMapper defaultaddrMapper;

    public Bean add(int aid,int uid){
        Bean<String> res = new Bean<>();
        if(defaultaddrMapper.have(uid) == null){
            defaultaddrMapper.add(aid,uid);
        }else{
            defaultaddrMapper.update(aid,uid);
        }
        res.setRespCode(0);
        res.setMessage("设置默认地址");
        return res;
    }

    public Bean check(int uid){
        Bean<Defaultaddr> res = new Bean<>();
        Defaultaddr aid = defaultaddrMapper.have(uid);
        res.setRespCode(0);
        res.setMessage("ok");
        res.setData(aid);
        return res;
    }

    public Bean detail(int uid){
        Bean<Defaultaddr> res = new Bean<>();
        if(defaultaddrMapper.have(uid) == null){
            res.setRespCode(1);
            res.setMessage("请设置默认地址");
            return res;
        }
        Defaultaddr data = defaultaddrMapper.detail(uid);
        res.setRespCode(0);
        res.setMessage("ok");
        res.setData(data);
        return res;
    }
}
