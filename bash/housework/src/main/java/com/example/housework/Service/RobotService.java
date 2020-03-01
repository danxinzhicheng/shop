package com.example.housework.Service;

import com.example.housework.mapper.RobotMapper;
import com.example.housework.pojo.Robot;
import com.example.housework.vo.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RobotService {
    @Autowired
    RobotMapper robotMapper;

    public Bean findTalk(String word){
        Bean<Robot> res = new Bean<>();
        Robot result = null;
        try{
            result = robotMapper.findTalk(word);
        }catch (Exception e){
            res.setRespCode(1);  //失败为1，成功为0
            res.setMessage(e.toString());
        }
        if(result == null){
            result = robotMapper.findTalk("其他");
        }
        res.setRespCode(0);
        res.setMessage("ok");
        res.setData(result);
        return res;
    }
}
