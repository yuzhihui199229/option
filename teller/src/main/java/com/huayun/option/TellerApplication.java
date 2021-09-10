package com.huayun.option;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.huayun.option.mapper")
@EnableSwagger2
public class TellerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TellerApplication.class,args);
    }
}
