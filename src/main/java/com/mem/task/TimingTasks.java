
package com.mem.task;

import com.mem.mapper.DataMapper;
import com.mem.mapper.UserMapper;
import com.mem.mapper.WordMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
@Slf4j
@Component
public class TimingTasks {
    @Autowired
    WordMapper wordMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    DataMapper dataMapper;
    @Scheduled(cron = "0 0 0 * * ?")
    public void updatePointer(){
        log.info("更新pointer");
        wordMapper.updatePointer();


    }
    @Scheduled(cron = "0 * * * * ?")
    public void updateNum(){
        //更新单词数据的统计,每分钟更新一次
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        //设置时区
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));

        List<String> uids=userMapper.getAll();
        //删一次再更新一次是没有找到Mysql的if else语句可以实现没有唯一键的情况下不存在就插入,存在则更新的例子
        //虽然操作比较儍狗,万一用户量多起来就bbq了,不过是自用的哈哈哈
        dataMapper.deleteNum(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.DATE));
        for (String uid:uids
             ) {

            int reviewNum = wordMapper.getTodayWords(uid).size();
            int addNum=wordMapper.getAddedWords(uid).size();

            dataMapper.insertNum(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.DATE),addNum,reviewNum,uid);
        }

    }
}

