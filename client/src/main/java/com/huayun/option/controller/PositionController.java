package com.huayun.option.controller;

import com.huayun.option.model.MagicNo;
import com.huayun.option.protobuf.Protocol;
import com.huayun.option.request.ReqAssetInfoAndOptionPosition;
import com.huayun.option.request.ReqUserInfo;
import com.huayun.option.response.Result;
import com.huayun.option.response.RspOptionPosition;
import com.huayun.option.response.RspUserInfo;
import com.huayun.option.service.ProtoBufService;
import com.huayun.option.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
@Api(tags = "持仓管理")
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private ProtoBufService protoBufService;

    @PostMapping("/getOptionPositionList")
    @ApiOperation(value = "根据用户id，查询相关的持仓信息")
    public Result getOptionPositionList(@RequestBody ReqAssetInfoAndOptionPosition reqOptionPositionInfo) {
        //将请求参数转化为byte数组
        byte[] reqBytes = reqOptionPositionInfo.formatRequest();
        try {
            Protocol protocol = protoBufService.protoBufTurn(reqBytes);
            //向服务端发送数据并接收服务端消息
            byte[] rspBytes = protocol.getBody();
            //将byte数组转化为需要的数据
            List<RspOptionPosition> rspOptionPositions = new RspOptionPosition().parseResponse(rspBytes);
            return ResultUtil.getResult(protocol,rspOptionPositions);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(MagicNo.SYSTEM_ERROR, e.getMessage());
        }
    }
}
