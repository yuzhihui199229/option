package com.huayun.option.controller;

import com.huayun.option.model.MagicNo;
import com.huayun.option.protobuf.Protocol;
import com.huayun.option.request.ReqAssetInfo;
import com.huayun.option.request.ReqAssetLog;
import com.huayun.option.response.Result;
import com.huayun.option.response.RspSelAssetInfo;
import com.huayun.option.response.RspSelAssetLog;
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
@Api(tags = "资金管理")
@RequestMapping("/asset")
public class AssetController {
    @Autowired
    private ProtoBufService protoBufService;

    @PostMapping("/getAssetInfo/{uuserId}")
    @ApiOperation(value = "资金查询")
    public Result getAssetInfo(@RequestBody ReqAssetInfo reqAssetInfo,@PathVariable("uuserId") Integer uuserId) {
        try {
            //将请求参数转化为byte数组
            byte[] reqBytes = reqAssetInfo.formatRequest(uuserId);
            //向服务端发送数据并接收服务端消息
            byte[] rspBytes = protoBufService.parseByprotoBuf(reqBytes);
            //将byte数组转化为需要的数据
            Protocol protocol = new RspSelAssetInfo().parseResponse(rspBytes);
            //将结果封装并返回
            return ResultUtil.getResult(protocol);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(MagicNo.SYSTEM_ERROR, e.getMessage());
        }
    }

    @PostMapping("/getAssetLog/{uuserId}")
    @ApiOperation(value = "资金流水查询")
    public Result getAssetLog(@RequestBody ReqAssetLog reqAssetLog,@PathVariable("uuserId")Integer uuserId) {
        try {
            //将请求参数转化为byte数组
            byte[] reqBytes = reqAssetLog.formatRequest(uuserId);
            //向服务端发送数据并接收服务端消息
            byte[] rspBytes = protoBufService.parseByprotoBuf(reqBytes);
            //将byte数组转化为需要的数据
            Protocol protocol = new RspSelAssetLog().parseResponse(rspBytes);
            //将结果封装并返回
            return ResultUtil.getResult(protocol);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(MagicNo.SYSTEM_ERROR, e.getMessage());
        }
    }
}
