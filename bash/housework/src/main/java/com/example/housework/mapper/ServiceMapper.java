package com.example.housework.mapper;

import com.example.housework.pojo.Service;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ServiceMapper {

    @Select("Select * from service where type = #{type}")
    List<Service> list(@Param("type") String type);

    @Select("Select * from service where id in (1,2,9,11,13,14,18,19)")
    List<Service> recommend();

    @Select("Select * from service where id = #{id}")
    Service detail(@Param("id") int id);
}
