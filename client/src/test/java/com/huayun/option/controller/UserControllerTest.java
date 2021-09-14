package com.huayun.option.controller;

import com.huayun.option.request.ReqLogin;
import com.huayun.option.request.ReqUserInfo;
import com.huayun.option.response.Result;
import com.huayun.option.response.RspLogin;
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

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

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
        ReqUserInfo reqUserInfo = new ReqUserInfo();
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
        //将返回值转化为对象打印出来
        log.info(mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));
    }


    /**
     * 将content写入到一个文件
     *
     * @param content 写入的内容
     * @param fileName 文件名
     * @throws IOException
     */
    private void writeTokenToTxt(String content,String fileName) throws IOException {
        //指定文件路径
        String path = System.getProperty("user.dir") + "\\src\\test\\java\\com\\huayun\\option\\controller\\";
        //创建文件对象
        File file = new File(path, fileName);
        //创建文件
        if (!file.exists()) {
            file.createNewFile();
        }
        byte[] tokenBytes = new byte[512];
        tokenBytes = content.getBytes(StandardCharsets.UTF_8);
        //创建文件流对象
        FileOutputStream fos = new FileOutputStream(file);
        //将字符创写入文件流
        fos.write(tokenBytes, 0, tokenBytes.length);
        fos.close();
    }

    static String readTokenFromTxt(String fileName) {
        String path = System.getProperty("user.dir") + "\\src\\test\\java\\com\\huayun\\option\\controller\\";
        File file = new File(path, fileName);
        InputStream in = null;
        StringBuffer sb = new StringBuffer();
        //判断文件是否存在
        if (file.isFile() && file.exists()) {
            // 一次读多个字节
            byte[] tempbytes = new byte[1024];
            int byteread = 0;
            try {
                in = new FileInputStream(file);
                while ((byteread = in.read(tempbytes)) != -1) {
                    String str = new String(tempbytes, 0, byteread);
                    sb.append(str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            log.info("找不到指定的文件，请确认文件路径是否正确");
        }
        return sb.toString();
    }


    @Test
    void login() throws Exception {
        //封装请求的数据
        ReqLogin reqLogin = new ReqLogin();
        reqLogin.setUserID("wenw")
                .setPassword("123456");
        MvcResult mvcResult = mockMvc.perform(
                //请求的方法
                post("/user/login")
                        //输入的数据类型
                        .contentType(MediaType.APPLICATION_JSON)
                        //输入的数据
                        .content(JsonUtil.objectToJson(reqLogin)))
                //获取返回值
                .andReturn();
        String responseStr = mvcResult.getResponse().getContentAsString(Charset.defaultCharset());
        //将返回值转化为对象打印出来
        log.info(responseStr);
        Result result = JsonUtil.jsonToPojo(responseStr, Result.class);
        Map<String,Object> data = (Map<String,Object>)result.getData();
        String token = (String) data.get("token");
        int id = (int)data.get("id");
        int uuserID = (int)data.get("uuserID");
        writeTokenToTxt(token,"token.txt");
        writeTokenToTxt(id+"","sessionID.txt");
        writeTokenToTxt(uuserID+"","uuserID.txt");
    }
}