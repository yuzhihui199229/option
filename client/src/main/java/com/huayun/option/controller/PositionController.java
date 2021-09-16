package com.huayun.option.controller;

import com.huayun.option.model.MagicNo;
import com.huayun.option.protobuf.Protocol;
import com.huayun.option.request.ReqOptionPosition;
import com.huayun.option.response.Result;
import com.huayun.option.response.RspSelOption;
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
@Api(tags = "持仓管理")
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private ProtoBufService protoBufService;

    @PostMapping("/getOptionPositionList/{uuserId}")
    @ApiOperation(value = "根据用户id，查询相关的持仓信息")
    public Result getOptionPositionList(@RequestBody ReqOptionPosition reqOptionPosition,@PathVariable("uuserId") Integer uuserId) {
        try {
            //将请求参数转化为byte数组
            byte[] reqBytes = reqOptionPosition.formatRequest(uuserId);
            //向服务端发送数据并接收服务端消息
            byte[] rspBytes = protoBufService.parseByprotoBuf(reqBytes);
            //将byte数组转化为需要的数据
            Protocol protocol = new RspSelOption().parseResponse(rspBytes);
            return ResultUtil.getResult(protocol);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(MagicNo.SYSTEM_ERROR, e.getMessage());
        }
    }
}
