package com.example.housework.mapper;

import com.example.housework.pojo.Order;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface OrderMapper {
    @Insert("Insert into `order` (sid,uid,activetime,failuretime,address,area,name,mobile) values(#{sid},#{uid},#{activetime},#{failuretime},#{address},#{area},#{name},#{mobile})")
    boolean add(@Param("sid") int sid, @Param("uid") int uid, @Param("activetime") Date activetime, @Param("failuretime") Date failuretime,@Param("address") String address,@Param("area") String area, @Param("name") String name, @Param("mobile") String mobile);

    @Select("Select * from `order` where uid = #{uid}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "sid",column = "sid",
                    one = @One(select = "com.example.housework.mapper.ServiceMapper.detail")),
    })
    List<Order> list(@Param("uid") int uid);
}
