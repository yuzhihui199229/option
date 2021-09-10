package com.huayun.option.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Slf4j
class TbPositionLimitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("根据标的物ID和股东账户ID查询持仓限额配置")
    void selectByCondition() throws Exception {
        String token = TbTellInfoControllerTest.readTokenFromTxt();
        MvcResult mvcResult = mockMvc.perform(
                //请求的方法
                get("/option/positionLimit/selectByCondition")
                        .param("usecurityId","123")
//                        .param("uaccountId","124")
                        .header("token", token))
                //获取返回值
                .andReturn();
        log.info(mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));
    }
}