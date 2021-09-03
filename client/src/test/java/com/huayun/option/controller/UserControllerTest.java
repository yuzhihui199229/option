package com.huayun.option.controller;

import com.huayun.option.request.ReqUserInfo;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Slf4j
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("查询用户信息")
    void getUserInfoList() throws Exception {
        //封装请求的数据
        ReqUserInfo reqUserInfo=new ReqUserInfo();
            reqUserInfo.setUserId("my_id");
        MvcResult mvcResult = mockMvc.perform(
                //请求的方法
                post("/user/getUserInfoList")
                        //输入的数据类型
                        .contentType(MediaType.APPLICATION_JSON)
                        //输入的数据
                        .content(JsonUtil.objectToJson(reqUserInfo)))
                //获取返回值
                .andReturn();
    }
}