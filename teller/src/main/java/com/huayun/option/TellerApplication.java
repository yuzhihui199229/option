package com.huayun.option;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.huayun.option.mapper")
public class TellerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TellerApplication.class,args);
    }
}
