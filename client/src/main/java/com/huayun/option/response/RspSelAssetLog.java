package com.huayun.option.response;

import com.google.protobuf.InvalidProtocolBufferException;
import com.huayun.option.protobuf.ClientMgr;
import com.huayun.option.protobuf.Protocol;
import com.huayun.option.utils.ProtoJsonUtil;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.IOException;

@Data
@Accessors(chain = true)
@ApiModel(value = "RspSelAssetInfo",description = "资金流水响应")
public class RspSelAssetLog extends BaseResponse{

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
        ClientMgr.RspSelAssetLog protobuf = ClientMgr.RspSelAssetLog.parseFrom(bodyBytes);
        //protobuf转化为json
        String body = ProtoJsonUtil.toJson(protobuf);
        protocol.setBody(body);
        return protocol;

    }

}
