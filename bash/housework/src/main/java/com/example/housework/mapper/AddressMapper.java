package com.example.housework.mapper;

import com.example.housework.pojo.Address;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AddressMapper {

    @Insert("Insert into address(address,area,name,mobile,uid) values(#{address},#{area},#{name},#{mobile},#{uid})")
    boolean add(@Param("address") String address,@Param("area") String area,@Param("name") String name,@Param("mobile") String mobile,@Param("uid") int uid);

    @Select("Select id from address where uid = #{uid} order by id desc limit 1")
    int findid(int uid);

    @Select("Select * from address where uid = #{uid}")
    List<Address> list(@Param("uid") int uid);

    @Update("Update address set address=#{address},area=#{area},name=#{name},mobile=#{mobile} where id=#{id}")
    boolean update(@Param("address") String address,@Param("area") String area,@Param("name") String name,@Param("mobile") String mobile,@Param("id") int id);

    @Select("Select * from address where id = #{id}")
    Address selectone(@Param("id") int id);
}
