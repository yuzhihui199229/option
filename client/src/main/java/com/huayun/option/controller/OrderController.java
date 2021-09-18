package com.huayun.option.controller;

import com.huayun.option.codec.ProtocolCodec;
import com.huayun.option.model.MagicNo;
import com.huayun.option.protobuf.Protocol;
import com.huayun.option.request.ReqOptionPosition;
import com.huayun.option.request.ReqOrderAdd;
import com.huayun.option.response.Result;
import com.huayun.option.response.RspOrderAdd;
import com.huayun.option.response.RspSelOption;
import com.huayun.option.service.CodecService;
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
@Api(tags = "订单管理")
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private CodecService codecService;

    @PostMapping("/orderAdd/{uuserId}/{sessionID}")
    @ApiOperation(value = "用户下单")
    public Result orderAdd(@RequestBody ReqOrderAdd request, @PathVariable("uuserId") Integer uuserId, @PathVariable("sessionID") Integer sessionID) {
        try {
            //格式化将请求参数
            ProtocolCodec protocolCodec = request.formatRequest(uuserId, sessionID);
            //向服务端发送数据并接收服务端消息
            ProtocolCodec response = codecService.parseByCodec(protocolCodec);
            //将byte数组转化为需要的数据
            RspOrderAdd body = new RspOrderAdd().parseResponse(response.getBody());
            return ResultUtil.getResult(response.getHeadCodec(), body);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(MagicNo.SYSTEM_ERROR, e.getMessage());
        }
    }
}
