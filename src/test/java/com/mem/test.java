package com.mem;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class test {

    @Test
    public void testWord() throws Exception{
        String word="hello";
        String cmd="python H:\\python\\verify.py "+word;
        Process process=null;
        process = Runtime.getRuntime().exec(cmd);
        InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String res=bufferedReader.readLine();
        if(res.equals("True")){
            System.out.println("是单词");
        }else{
            System.out.println("不是单词");
        }


    }
}
