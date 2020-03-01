package com.example.housework.mapper;

import com.example.housework.pojo.Robot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface RobotMapper {
    @Select("select * from robot where word like  CONCAT('%',#{word},'%')")
    Robot findTalk(String word);
}
