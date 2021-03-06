package com.huayun.option.response;

import com.google.protobuf.InvalidProtocolBufferException;
import com.huayun.option.protobuf.ClientMgr;
import com.huayun.option.protobuf.Protocol;
import com.huayun.option.utils.ProtoJsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.IOException;

@Data
@Accessors(chain = true)
@ApiModel(value = "RspLoginZmq", description = "登录应答")
public class RspLogin extends BaseResponse{

    @ApiModelProperty(value = "token,", dataType = "Char[32]")
    private String token;

    @ApiModelProperty(value = "sessionId")
    private Integer id;

    @ApiModelProperty(value = "用户ID,", dataType = "Char[12]", required = true)
    private Integer uuserId;

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
        ClientMgr.RspLogin protobuf = ClientMgr.RspLogin.parseFrom(bodyBytes);
        //protobuf转化为json
        String body = ProtoJsonUtil.toJson(protobuf);
        protocol.setBody(body);
        return protocol;
    }

}
