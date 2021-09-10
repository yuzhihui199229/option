package com.huayun.option.controller;

import com.huayun.option.request.ReqAssetInfo;
import com.huayun.option.request.ReqAssetLog;
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

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Slf4j
class AssetControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("查询资金信息")
    void getAssetInfo() throws Exception {
        String token = UserControllerTest.readTokenFromTxt("token.txt");
        String uuserID = UserControllerTest.readTokenFromTxt("uuserID.txt");
        //封装请求的数据
        ReqAssetInfo reqAssetInfo = new ReqAssetInfo();
        reqAssetInfo.setToken(token)
                .setUuserId(Integer.parseInt(uuserID));
        MvcResult mvcResult = mockMvc.perform(
                //请求的方法
                post("/asset/getAssetInfo")
                        //输入的数据类型
                        .contentType(MediaType.APPLICATION_JSON)
                        //输入的数据
                        .content(JsonUtil.objectToJson(reqAssetInfo)))
                //获取返回值
                .andReturn();
        //将返回值转化为对象打印出来
        log.info(mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));
    }

    @Test
    @DisplayName("查询流水信息")
    void getAssetLog() throws Exception {
        String token = UserControllerTest.readTokenFromTxt("token.txt");
        String uuserID = UserControllerTest.readTokenFromTxt("uuserID.txt");
        //封装请求的数据
        ReqAssetLog reqAssetLog = new ReqAssetLog();
        reqAssetLog.setToken(token)
                .setUuserId(Integer.parseInt(uuserID));
        MvcResult mvcResult = mockMvc.perform(
                //请求的方法
                post("/asset/getAssetLog")
                        //输入的数据类型
                        .contentType(MediaType.APPLICATION_JSON)
                        //输入的数据
                        .content(JsonUtil.objectToJson(reqAssetLog)))
                //获取返回值
                .andReturn();
        //将返回值转化为对象打印出来
        log.info(mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));
    }
}