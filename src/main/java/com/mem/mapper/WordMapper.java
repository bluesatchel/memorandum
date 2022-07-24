package com.mem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mem.model.User;
import com.mem.model.Word;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface WordMapper extends BaseMapper<Word> {
    //一次插入一堆单词
    @Insert("<script>" +
            "INSERT INTO `mem`.`words`(`wid`, `uid`, `value`, `time`, `marked`, `pointer`)VALUES" +
            "<foreach collection='list' item='item'   separator=','> " +
            "(#{item.wid},#{item.uid},#{item.value},#{item.time},0,0)" +
            "</foreach> " +
            "</script>")
    boolean insertWords(@Param("list") List<Word> words);
    //一次插入一个单词
    @Insert("INSERT INTO `mem`.`words`(`wid`, `uid`, `value`, `time`, `marked`, `pointer`,`year`,`month`,`day`)VALUES"+
            "(#{word.wid},#{word.uid},#{word.value},#{word.time},0,0,#{word.year},#{word.month},#{word.day})"
    )
    boolean insertWord(@Param("word") Word word);

    //标记单词
    @Update("UPDATE `mem`.`words` SET `pointer` = 0 WHERE `wid` = #{wid}")
    boolean markWord(@Param("wid") String wid);

    @Update("UPDATE `mem`.`words` SET pointer = pointer+1")
    boolean updatePointer();

    //获取今日单词
    @Select("select * from `mem`.`words` where uid=#{uid} and pointer in (1,2,4,7,15,30)")
    List<Word> getTodayWords(@Param("uid") String uid);

    @Select("select * from `mem`.`words` where uid=#{uid} and pointer =0")
    List<Word> getAddedWords(@Param("uid") String uid);


}
