package com.example.housework.Service;

import com.example.housework.mapper.CollectionMapper;
import com.example.housework.pojo.Collection;
import com.example.housework.vo.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CollectionService {
    @Autowired
    CollectionMapper collectionMapper;

    public Bean add(int uid,int sid){
        Bean<String> res = new Bean<>();
        Date date = new Date();
        if(collectionMapper.add(uid,sid,date)){
            res.setRespCode(0);
            res.setMessage("收藏成功");
            return res;
        }
        res.setRespCode(1);
        res.setMessage("收藏失败");
        return res;
    }

    public Bean reduce(int uid,int sid){
        Bean<String> res = new Bean<>();
        if(collectionMapper.reduce(uid,sid)){
            res.setRespCode(0);
            res.setMessage("删除收藏");
            return res;
        }
        res.setRespCode(1);
        res.setMessage("删除失败");
        return res;
    }

    public Bean isCollection(int uid,int sid){
        Bean<Collection> res = new Bean<>();
        if(collectionMapper.isCollection(uid,sid) != null){
            res.setRespCode(0);
            res.setMessage("该商品已收藏");
            return res;
        }
        res.setRespCode(1);
        res.setMessage("该商品未收藏");
        return res;
    }

    public Bean list(int uid){
        Bean<List<Collection>> res = new Bean<>();
        List<Collection> list = collectionMapper.list(uid);
        res.setRespCode(0);
        res.setMessage("收藏列表");
        res.setData(list);
        return res;
    }
}
