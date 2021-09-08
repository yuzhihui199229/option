package com.huayun.option.controller;

import lombok.extern.slf4j.Slf4j;
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
class TbOptionInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void selectList() throws Exception {
        String token = TbTellInfoControllerTest.readTokenFromTxt();
        MvcResult mvcResult = mockMvc.perform(
                //请求的方法
                get("/optionInfo/selectList")
                        .header("token", token))
                //获取返回值
                .andReturn();
        log.info(mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));
    }
}