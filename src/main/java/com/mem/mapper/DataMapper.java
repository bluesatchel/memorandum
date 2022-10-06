package com.mem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mem.model.Data;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DataMapper extends BaseMapper<Data> {


    //获取一个月的数据
    @Select("SELECT * FROM `mem`.`data` where uid = #{uid} and (year=#{year} and month=#{month})")
    List<Data> getOneMonth(@Param("uid") String uid,@Param("year") int year, @Param("month") int month);

    @Select("SELECT * FROM `mem`.`data` where uid = #{uid} and year=#{year}")
    List<Data> getOneYear(@Param("uid") String uid,@Param("year") int year);

    //根据传入的具体到天数的时间删除当日统计数据
    @Delete("DELETE FROM `mem`.`data` WHERE `year` = #{year} AND `month` = #{month} AND `day` = #{day} ")
    boolean deleteNum(@Param("year") int year,@Param("month") int month , @Param("day") int day);

    //根据传入的具体到天数的时间重新插入当天数据
    @Insert("INSERT INTO `mem`.`data`(`year`, `month`, `day`, `addnum`, `reviewnum`, `uid`) VALUES (#{year},#{month}, #{day}, #{addnum}, #{reviewnum}, #{uid})")
    boolean insertNum(@Param("year") int year,@Param("month") int month , @Param("day") int day,@Param("addnum") int addnum,@Param("reviewnum") int reviewnum,@Param("uid") String uid);


    @Select("select DISTINCT data.`month` from data where year=#{year}")
    List<Integer> getMonthes(@Param("uid") String uid,@Param("year") int year);




}
