package com.mem;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@Slf4j
@SpringBootApplication
@EnableScheduling
@MapperScan("com.mem.mapper")
public class MyApplication {

    public static void main(String[] args) {

        SpringApplication.run(MyApplication.class,args);

    }
}
