package com.example.housework.mapper;

import com.example.housework.pojo.Defaultaddr;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DefaultaddrMapper {

    @Insert("Insert into defaultaddr (aid,uid) values(#{aid},#{uid})")
    boolean add(@Param("aid") int aid,@Param("uid") int uid);

    @Select("Select * from defaultaddr where uid = #{uid}")
    Defaultaddr have(@Param("uid") int uid);

    @Update("Update defaultaddr set aid=#{aid} where uid = #{uid}")
    boolean update(@Param("aid") int aid,@Param("uid") int uid);

    @Delete("Delete from defaultaddr where uid = #{uid}")
    boolean delete(@Param("uid") int uid);

    @Select("Select * from defaultaddr where uid = #{uid}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "address",column = "aid",
                    one = @One(select = "com.example.housework.mapper.AddressMapper.selectone")),
    })
    Defaultaddr detail(@Param("uid") int uid);
}
