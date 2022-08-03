package com.mem.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component//添加到Spring容器中
public class UUIDUtil {
    //生成一个32位的uuid
    public static String getUUID32(){


        return UUID.randomUUID().toString().replace("-","").toLowerCase();
    }
    //生成指定数量的uuid
    public static String[] getUUID(int num){

        if(num<=0){
            return null;
        }
        String[] uuidArray=new String[num];


        for(int i=0;i<uuidArray.length;i++){
            uuidArray[i]=getUUID32();
        }
        return uuidArray;

    }
}
