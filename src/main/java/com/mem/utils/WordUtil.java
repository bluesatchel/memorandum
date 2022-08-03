package com.mem.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class WordUtil {
    public static HashMap<String,String> words;


    public static HashMap<String,String> getWords(){
        words=new HashMap<String,String>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/root/dict/list.txt"));
            String line = reader.readLine();
            while (line != null) {
                words.put(line,line+".json");

                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;







    }
}
