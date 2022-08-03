package com.mem.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mem.mapper.*;
import com.mem.model.Data;
import com.mem.model.R;
import com.mem.model.User;
import com.mem.model.Word;
import com.mem.model.vo.AddWord;

import com.mem.service.WordService;
import com.mem.utils.UUIDUtil;
import com.mem.utils.WordUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@Slf4j
@Api(tags = "单词管理")
@RestController
@RequestMapping("/word")
public class WordController {
    @Autowired
    WordService wordService;

    @Autowired
    WordMapper wordMapper;

    @Autowired
    DataMapper dataMapper;


    @ApiOperation(value = "添加一个单词", notes = "传递一个uid和单词")
    @PostMapping("addWord")

    public R addWord(@RequestBody AddWord addWord) throws Exception {
        R r = new R(R.FAIL, "添加失败");
        String target = addWord.getValue();
        String cmd = "python3 /root/verify.py " + target;
        //String cmd="python H:\\python\\verify.py "+target;
        Process process = null;
        process = Runtime.getRuntime().exec(cmd);
        InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String res = bufferedReader.readLine();
        //是单词
        if (res.equals("True")) {

            TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
            //设置时区
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
            boolean flag = false;
            Word word = new Word(addWord.getUid(), UUIDUtil.getUUID32(), addWord.getValue(), String.valueOf(System.currentTimeMillis()), calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));
            flag = wordMapper.insertWord(word);
            if (flag) {
                r.setStatus(R.SUCCESS);
                r.setMessage("添加成功");
            }
        } else {
            r.setStatus(R.FAIL);
            r.setMessage("输入的单词不正确!");
        }


        return r;
    }

    @ApiOperation(value = "添加一个短语或者句子", notes = "传递一个uid和value")
    @PostMapping("addGroup")
    //类就先用AddWord顶替一下
    public R addGroup(@RequestBody AddWord addWord) throws Exception {
        R r = new R(R.FAIL, "添加失败");

        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        //设置时区
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        boolean flag = false;
        Word word = new Word(addWord.getUid(), UUIDUtil.getUUID32(), addWord.getValue(), String.valueOf(System.currentTimeMillis()), calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));
        //一起插入到单词表里面,目前量不大,后期背写作大了再单独分表
        flag = wordMapper.insertWord(word);
        if (flag) {
            r.setStatus(R.SUCCESS);
            r.setMessage("添加成功");
        }


        return r;
    }

    @ApiOperation(value = "推送今日单词", notes = "直接Post带uid请求")
    @PostMapping("todayWords")
    public R getTodayWords(@RequestBody User user) {
        R r = new R(R.FAIL, "获取失败");

        List<Word> todayWords = wordMapper.getTodayWords(user.getUid());

        r.setStatus(R.SUCCESS);
        r.setMessage("获取成功");


        r.setData(todayWords);
        return r;
    }

    @ApiOperation(value = "标记不会的单词", notes = "标记不会的单词,并且将日期顺延到明天推送,但是好像标记没啥用,直接把pointer置0就行了")
    @PostMapping("mark")
    public R markWords(@RequestBody String wid) {

        boolean flag = wordMapper.markWord(wid);

        R r = new R(R.FAIL, "修改失败");

        if (flag) {
            r.setStatus(R.SUCCESS);
            r.setMessage("修改成功");
        }


        return r;
    }


    @ApiOperation(value = "获取所有单词", notes = "直接Post带uid请求")
    @PostMapping("allWords")
    public R getAllWords(@RequestBody User user) {
        R r = new R(R.FAIL, "获取失败");

        List<Word> allWords = wordService.list(new QueryWrapper<Word>().eq("uid", user.getUid()));

        r.setStatus(R.SUCCESS);
        r.setMessage("获取成功");


        r.setData(allWords);
        return r;
    }

    @ApiOperation(value = "获取本月数据", notes = "直接Post带uid请求")
    @PostMapping("thisMonthData")
    public R getThisMonthData(String uid) {
        R r = new R(R.FAIL, "获取失败");
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        //设置时区
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        List<Data> oneMonth = dataMapper.getOneMonth(uid, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1);


        if (oneMonth.size() != 0) {
            r.setData(oneMonth);
            r.setStatus(R.SUCCESS);
            r.setMessage("获取成功");
        }


        return r;
    }

    @ApiOperation(value = "获取单词的数据", notes = "获取单词数据,如果前端查不到的话,再去请求有道的接口")
    @PostMapping("getWordInfo")
    public R getWordInfo(String word) {
        BufferedReader reader;

        R r = new R(R.FAIL, "获取失败");

        HashMap<String, String> words = WordUtil.getWords();
        if (words.containsKey(word)) {
            try {
                StringBuilder sb = new StringBuilder();

                reader = new BufferedReader(new FileReader(
                        "/root/dict/" + words.get(word)));
                String line = reader.readLine();
                while (line != null) {
                    sb.append(line);
                    // read next line
                    line = reader.readLine();
                }
                reader.close();
                Object parse = JSON.parse(sb.toString());
                r.setData(parse);
                r.setStatus(R.SUCCESS);
                r.setMessage("获取成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            log.info("{}没有数据", word);
            r.setStatus(R.NOT_FOUND);
            r.setMessage("获取失败");
        }


        return r;
    }


}
