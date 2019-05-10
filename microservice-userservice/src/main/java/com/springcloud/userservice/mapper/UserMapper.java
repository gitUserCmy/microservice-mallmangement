package com.springcloud.userservice.mapper;


import com.springcloud.userservice.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {


    @Select("select * from tb_user where username =#{username}")
    User selectUser(String username);
}
