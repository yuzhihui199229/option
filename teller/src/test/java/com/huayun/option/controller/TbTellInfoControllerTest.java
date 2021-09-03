package com.huayun.option.controller;

import com.huayun.option.TellerApplication;
import com.huayun.option.entity.TbTellInfo;
import com.huayun.option.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TellerApplication.class)
@AutoConfigureMockMvc
@Slf4j
class TbTellInfoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("测试登录的方法")
    void login() throws Exception {
        //封装输入的参数
        TbTellInfo tellInfo = new TbTellInfo();
        tellInfo.setUserName("admin")
                .setPassword("123456");
        //调用MockMVC实现http通信
        MvcResult mvcResult = mockMvc.perform(
                //请求的方法
                post("/tellInfo/login")
                        //输入的数据类型
                        .contentType(MediaType.APPLICATION_JSON)
                        //输入的数据
                        .content(JsonUtil.objectToJson(tellInfo)))
                //获取返回值
                .andReturn();
        //将返回值转化为对象打印出来
        log.info(mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));
    }
}