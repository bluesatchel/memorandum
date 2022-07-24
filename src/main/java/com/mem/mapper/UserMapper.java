package com.mem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mem.model.User;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    @Select("select * from `user` where username=#{user.username} and password=#{user.password}")
    User login(@Param("user") User user);

    @Insert("INSERT INTO `mem`.`user`(`uid`,`username`, `password`, `nickname`) VALUES (#{user.uid},#{user.username}, #{user.password},#{user.nickname})")
    boolean register(@Param("user") User user);


    @Select("select uid from `user`")
    List<String> getAll();
}