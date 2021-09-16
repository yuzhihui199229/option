package com.huayun.option.response;

import com.google.protobuf.InvalidProtocolBufferException;
import com.huayun.option.protobuf.ClientMgr;
import com.huayun.option.protobuf.Protocol;
import com.huayun.option.utils.ProtoJsonUtil;

import java.io.IOException;

public class SelStrategyCombineLog extends BaseResponse{
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
        ClientMgr.SelStrategyCombineLog protobuf = ClientMgr.SelStrategyCombineLog.parseFrom(bodyBytes);
        //protobuf转化为json
        String body = ProtoJsonUtil.toJson(protobuf);
        protocol.setBody(body);
        return protocol;
    }
}
