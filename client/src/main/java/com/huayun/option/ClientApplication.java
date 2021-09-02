package com.huayun.option;

import com.huayun.option.annotation.EnableRpcClient;
import com.huayun.option.zmq.ZmqClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableRpcClient(basePackages="com.huayun.option.service")
@EnableSwagger2
public class ClientApplication{
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class,args);
    }

//    @Value("${zmq.ip}")
//    private String ip;
//
//    @Value("${zmq.port}")
//    private int port;
//
//
//    @Override
//    public void run(String... args) throws Exception {
//        ZmqClient.createConnect(ip, port);
//    }
}
