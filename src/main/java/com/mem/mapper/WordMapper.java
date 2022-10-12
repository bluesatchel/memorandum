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
    /**一次插入一堆单词*/
    @Insert("<script>" +
            "INSERT INTO `mem`.`words`(`wid`, `uid`, `value`, `time`, `marked`, `pointer`)VALUES" +
            "<foreach collection='list' item='item'   separator=','> " +
            "(#{item.wid},#{item.uid},#{item.value},#{item.time},0,0)" +
            "</foreach> " +
            "</script>")
    boolean insertWords(@Param("list") List<Word> words);
    /**一次插入一个单词*/
    @Insert("INSERT INTO `mem`.`words`(`wid`, `uid`, `value`, `time`, `marked`, `pointer`,`year`,`month`,`day`,`custom_translation`)VALUES"+
            "(#{word.wid},#{word.uid},#{word.value},#{word.time},0,0,#{word.year},#{word.month},#{word.day},#{word.customTranslation})"
    )
    boolean insertWord(@Param("word") Word word);

    //标记单词
    @Update("UPDATE `mem`.`words` SET `marked` = 1 WHERE `wid` = #{wid}")
    boolean markWord(@Param("wid") String wid);
    //取消单词标记
    @Update("UPDATE `mem`.`words` SET `marked` = 0 WHERE `wid` = #{wid}")
    boolean unmarkWord(@Param("wid") String wid);
    /**获取指定wid的单词
     * @param wid 单词唯一标识 generated from uuid
     * */
    @Select("select * from `mem`.`words` where wid=#{wid} order by id")
    Word getOneWord(@Param("wid") String wid);

    @Update("UPDATE `mem`.`words` SET pointer = pointer+1")
    boolean updatePointer();

    //获取今日单词
    @Select("select * from `mem`.`words` where uid=#{uid} and pointer in (1,2,4,7,15,30) order by id")
    List<Word> getTodayWords(@Param("uid") String uid);

    @Select("select * from `mem`.`words` where uid=#{uid} and pointer =0 order by id")
    List<Word> getAddedWords(@Param("uid") String uid);
    /**
     * 获取已经超过30天的单词
     * */
    @Select("select * from `mem`.`words` where pointer > 30 order by id")
    List<Word> getFinishedWords(@Param("uid") String uid);


    /**
     * 获取已经超过30天且被标记的数据
     * */
    @Select("select * from `mem`.`words` where pointer > 30 and marked =1 order by id")
    List<Word> getFinishedMarkedWords(@Param("uid") String uid);

    /**
     * 获取被标记的数据
     * */
    @Select("select * from `mem`.`words` where marked =1 order by id")
    List<Word> getMarkedWords(@Param("uid") String uid);

    /**
     * 随机查询100个单词
     * */

    @Select("select * from `mem`.`words` where uid=#{uid} and id>=(select floor (RAND() * (select MAX(id) FROM `words`))) " +
            "order by id " +
            "limit 100")
    List<Word> getRandomWords(@Param("uid") String uid);

    /**
     * 随机查询100个单词超过30天的单词
     * */

    @Select("select * from `mem`.`words` where uid=#{uid} and pointer>30 and id>=(select floor (RAND() * (select MAX(id) FROM `words`))) " +
            "order by id " +
            "limit 100")
    List<Word> getRandomFinishedWords(@Param("uid") String uid);



}
