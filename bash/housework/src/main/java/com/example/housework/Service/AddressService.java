package com.example.housework.Service;

import com.example.housework.mapper.AddressMapper;
import com.example.housework.mapper.DefaultaddrMapper;
import com.example.housework.pojo.Address;
import com.example.housework.vo.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressMapper addressMapper;
    @Autowired
    DefalutaddrService defalutaddrService;
    @Autowired
    DefaultaddrMapper defaultaddrMapper;

    public Bean add(String address,String area,String name,String mobile,int uid,boolean befa){
        Bean<String> res = new Bean<>();
        if(addressMapper.add(address,area,name,mobile,uid)){
            res.setRespCode(0);
            res.setMessage("ok");
            if(befa){
                int aid = addressMapper.findid(uid);
                defalutaddrService.add(aid,uid);
            }
            return res;
        }
        res.setRespCode(1);
        res.setMessage("fail");
        return res;
    }

    public Bean list(int uid){
        Bean<List<Address>> res = new Bean<>();
        List<Address> list = addressMapper.list(uid);
        res.setRespCode(0);
        res.setMessage("ok");
        res.setData(list);
        return res;
    }

    public Bean update(int id,String address,String area,String name,String mobile,int uid,boolean befa) {
        Bean<String> res = new Bean<>();
        if(addressMapper.update(address,area,name,mobile,id)){
            res.setRespCode(0);
            res.setMessage("ok");
            if(befa){
                defalutaddrService.add(id,uid);
            }else{
                if(defaultaddrMapper.have(uid) != null){
                    defaultaddrMapper.delete(uid);
                }
            }
            return res;
        }
        res.setRespCode(1);
        res.setMessage("fail");
        return res;
    }
}
