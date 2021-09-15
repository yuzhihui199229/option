package com.huayun.option.response;

import com.google.protobuf.InvalidProtocolBufferException;
import com.huayun.option.protobuf.ClientMgr;
import com.huayun.option.protobuf.Protocol;
import com.huayun.option.utils.ProtoJsonUtil;
import io.swagger.annotations.ApiModel;

import java.io.IOException;

@ApiModel(value = "RspSelCombineStrategy",description = "组合策略持仓响应")
public class RspSelCombineStrategy extends BaseResponse{
    /**
     * 将字节码数组转化为Protocol
     * @param bytes
     * @return
     * @throws InvalidProtocolBufferException
     */
    @Override
    public Protocol parseResponse(byte[] bytes) throws IOException {
        Protocol protocol = super.parseResponse(bytes);
        byte[] bodyBytes = (byte[]) protocol.getBody();
        //将字节码数组通过protobuf转化
        ClientMgr.RspSelCombineStrategy protobuf = ClientMgr.RspSelCombineStrategy.parseFrom(bodyBytes);
        //protobuf转化为json
        String body = ProtoJsonUtil.toJson(protobuf);
        protocol.setBody(body);
        return protocol;
    }
}
