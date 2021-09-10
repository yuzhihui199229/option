package com.huayun.option.controller;

import com.huayun.option.protobuf.Protocol;
import com.huayun.option.request.ReqLogin;
import com.huayun.option.request.ReqUserInfo;
import com.huayun.option.response.RspLogin;
import com.huayun.option.response.RspUserInfo;
import com.huayun.option.service.ProtoBufService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
@Api(tags = "用户管理")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ProtoBufService protoBufService;

    @PostMapping("/getUserInfoList")
    @ApiOperation(value = "根据用户id，查询相关的用户信息")
    public RspUserInfo getUserInfoList(@RequestBody ReqUserInfo reqUserInfo) {
        //将reqUserInfo转化为byte数组
        byte[] reqBytes = reqUserInfo.getBytes();
        RspUserInfo result = null;
        try {
            Protocol protocol = protoBufService.protoBufTurn(reqBytes);
            //向服务端发送数据并接收服务端消息
            byte[] rspBytes = protocol.getBody();
            //将byte数组转化为需要的数据
            result = new RspUserInfo().getRspUserInfo(rspBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public RspLogin login(@RequestBody ReqLogin reqLogin) {
        //将reqUserInfo转化为byte数组
        byte[] reqBytes = reqLogin.getBytes();
        RspLogin result = null;
        try {
            Protocol protocol = protoBufService.protoBufTurn(reqBytes);
            //向服务端发送数据并接收服务端消息
            byte[] rspBytes = protocol.getBody();
            //将byte数组转化为需要的数据
            result = new RspLogin().getRspLogin(rspBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
