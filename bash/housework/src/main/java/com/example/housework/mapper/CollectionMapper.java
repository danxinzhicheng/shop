package com.example.housework.mapper;

import com.example.housework.pojo.Collection;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface CollectionMapper {

    @Insert("Insert into collection(uid,sid,time) values(#{uid},#{sid},#{time})")
    boolean add(@Param("uid") int uid,@Param("sid") int sid,@Param("time")  Date time);

    @Delete("delete from collection where uid = #{uid} and sid = #{sid}")
    boolean reduce(@Param("uid") int uid,@Param("sid") int sid);

    @Select("Select * from collection where uid = #{uid} and sid = #{sid}")
    Collection isCollection(@Param("uid") int uid,@Param("sid") int sid);

    @Select("Select * from collection where uid = #{uid}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "sid",column = "sid",
                    one = @One(select = "com.example.housework.mapper.ServiceMapper.detail")),
    })
    List<Collection> list(@Param("uid") int uid);
}
