package com.example.housework.Service;

import com.example.housework.mapper.ServiceMapper;
import com.example.housework.vo.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {
    @Autowired
    ServiceMapper serviceMapper;

    public Bean list(String type){
        Bean<List<com.example.housework.pojo.Service>> res = new Bean<>();
        List<com.example.housework.pojo.Service> list  = serviceMapper.list(type);
        res.setRespCode(0);
        res.setMessage("ok");
        res.setData(list);
        return res;
    }

    public Bean recommend(){
        Bean<List<com.example.housework.pojo.Service>> res = new Bean<>();
        List<com.example.housework.pojo.Service> list = serviceMapper.recommend();
        res.setRespCode(0);
        res.setMessage("ok");
        res.setData(list);
        return res;
    }

    public Bean detail(int id){
        Bean<com.example.housework.pojo.Service> res = new Bean<>();
        com.example.housework.pojo.Service se = serviceMapper.detail(id);
        res.setRespCode(0);
        res.setMessage("ok");
        res.setData(se);
        return res;
    }
}
