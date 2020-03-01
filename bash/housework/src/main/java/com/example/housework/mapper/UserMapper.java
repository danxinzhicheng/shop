package com.example.housework.mapper;

import com.example.housework.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("Insert into user(name,password) values (#{name},#{password})")
    boolean register(@Param("name") String name,@Param("password") String password);

    @Select("Select * from user where name = #{name} limit 1")
    List<User> isExsit(@Param("name") String name);

    @Select("Select * from user where name = #{name} and password = #{password} limit 1")
    List<User> login(@Param("name") String name,@Param("password") String password);

    @Select("Select id from user where name = #{name}")
    int uid(@Param("name") String name);
}
