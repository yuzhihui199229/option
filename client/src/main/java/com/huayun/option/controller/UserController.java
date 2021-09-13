package com.huayun.option.controller;

import com.huayun.option.model.MagicNo;
import com.huayun.option.protobuf.Protocol;
import com.huayun.option.request.ReqLogin;
import com.huayun.option.request.ReqUserInfo;
import com.huayun.option.response.Result;
import com.huayun.option.response.RspLogin;
import com.huayun.option.response.RspUserInfo;
import com.huayun.option.service.ProtoBufService;
import com.huayun.option.utils.ResultUtil;
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
    public Result getUserInfoList(@RequestBody ReqUserInfo reqUserInfo) {
        //将请求参数转化为byte数组
        byte[] reqBytes = reqUserInfo.getBytes();
        try {
            Protocol protocol = protoBufService.protoBufTurn(reqBytes);
            //向服务端发送数据并接收服务端消息
            byte[] rspBytes = protocol.getBody();
            //将byte数组转化为需要的数据
            RspUserInfo rspUserInfo = new RspUserInfo().getRspUserInfo(rspBytes);
            return ResultUtil.getResult(protocol,rspUserInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(MagicNo.SYSTEM_ERROR, e.getMessage());
        }
    }

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public Result login(@RequestBody ReqLogin reqLogin) {
        //将请求参数转化为byte数组
        byte[] reqBytes = reqLogin.getBytes();
        try {
            Protocol protocol = protoBufService.protoBufTurn(reqBytes);
            //向服务端发送数据并接收服务端消息
            byte[] rspBytes = protocol.getBody();
            //将byte数组转化为需要的数据
            RspLogin rspLogin = new RspLogin().parseResponse(rspBytes);
            return ResultUtil.getResult(protocol, rspLogin);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(MagicNo.SYSTEM_ERROR, e.getMessage());
        }
    }
}
