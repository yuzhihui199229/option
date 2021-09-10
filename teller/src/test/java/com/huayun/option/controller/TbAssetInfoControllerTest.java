package com.huayun.option.controller;

import com.huayun.option.TellerApplication;
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

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TellerApplication.class)
@AutoConfigureMockMvc
class TbAssetInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("根据条件查询资金信息")
    void selectByCondition() throws Exception {
        String token = TbTellInfoControllerTest.readTokenFromTxt();
        MvcResult mvcResult = mockMvc.perform(
                //请求的方法
                get("/option/tb-asset-info/selectByCondition")
                        .param("assetAccount","12345678")
//                        .param("uuserId","2")
                        .header("token", token))
                //获取返回值
                .andReturn();
        log.info(mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));
    }
}