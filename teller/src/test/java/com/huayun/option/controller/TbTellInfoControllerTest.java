package com.huayun.option.controller;

import com.huayun.option.TellerApplication;
import com.huayun.option.entity.Result;
import com.huayun.option.entity.TbTellInfo;
import com.huayun.option.utils.JsonUtil;
import com.huayun.option.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
        String responseStr = mvcResult.getResponse().getContentAsString(Charset.defaultCharset());
        Result result = JsonUtil.jsonToPojo(responseStr, Result.class);
        Map<String, Object> resultMap = (Map<String, Object>) result.getData();
        String token = (String) resultMap.get("token");
        //将token写入到文件
        writeTokenToTxt(token);
        System.out.println(readTokenFromTxt());
        //将返回值转化为对象打印出来
        log.info(mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));
    }

    /**
     * 将token写入到一个文件
     *
     * @param token
     * @throws IOException
     */
    private void writeTokenToTxt(String token) throws IOException {
        //指定文件路径
        String path = System.getProperty("user.dir") + "\\src\\test\\java\\com\\huayun\\option\\controller\\";
        //创建文件对象
        File file = new File(path, "token.txt");
        //创建文件
        if (!file.exists()) {
            file.createNewFile();
        }
        byte[] tokenBytes = new byte[512];
        tokenBytes = token.getBytes(StandardCharsets.UTF_8);
        //创建文件流对象
        FileOutputStream fos = new FileOutputStream(file);
        //将字符创写入文件流
        fos.write(tokenBytes, 0, tokenBytes.length);
        fos.close();
    }

    public static String readTokenFromTxt() {
        String path = System.getProperty("user.dir") + "\\src\\test\\java\\com\\huayun\\option\\controller\\";
        File file = new File(path, "token.txt");
        InputStream in = null;
        StringBuffer sb = new StringBuffer();
        //判断文件是否存在
        if (file.isFile() && file.exists()) {
            // 一次读多个字节
            byte[] tempbytes = new byte[1024];
            int byteread = 0;
            try {
                in = new FileInputStream(file);
                // 读入多个字节到字节数组中，byteread为一次读入的字节数
                while ((byteread = in.read(tempbytes)) != -1) {
                    //  System.out.write(tempbytes, 0, byteread);
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
    @DisplayName("查询所有的用户的信息")
    void selectList() throws Exception {
        String token = readTokenFromTxt();
        //调用MockMVC实现http通信
        MvcResult mvcResult = mockMvc.perform(
                //请求的方法
                get("/tellInfo/selectList")
                        .header("token", token))
                //获取返回值
                .andReturn();
        log.info(mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));
    }
}