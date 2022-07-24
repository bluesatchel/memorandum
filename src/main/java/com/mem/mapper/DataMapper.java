package com.mem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mem.model.Data;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DataMapper extends BaseMapper<Data> {


    @Select("SELECT * FROM `mem`.`data` where uid = #{uid} and (year=#{year} and month=#{month})")
    List<Data> getOneMonth(@Param("uid") String uid,@Param("year") int year, @Param("month") int month);

    @Select("SELECT * FROM `mem`.`data` where uid = #{uid} and year=#{year}")
    List<Data> getOneYear(@Param("uid") String uid,@Param("year") int year);

    @Insert("INSERT INTO `mem`.`data`(`year`, `month`, `day`, `addnum`, `reviewnum`, `uid`) VALUES (#{year},#{month}, #{day}, #{addnum}, #{reviewnum}, #{uid})")
    boolean insertNum(@Param("year") int year,@Param("month") int month , @Param("day") int day,@Param("addnum") int addnum,@Param("reviewnum") int reviewnum,@Param("uid") String uid);

    @Delete("DELETE FROM `mem`.`data` WHERE `year` = #{year} AND `month` = #{month} AND `day` = #{day} ")
    boolean deleteNum(@Param("year") int year,@Param("month") int month , @Param("day") int day);




}
