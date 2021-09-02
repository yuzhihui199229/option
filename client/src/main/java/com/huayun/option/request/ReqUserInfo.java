package com.huayun.option.request;

import com.huayun.option.model.MagicNo;
import com.huayun.option.model.MsgId;
import com.huayun.option.model.RetCode;
import com.huayun.option.protobuf.ClientMgr;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@Data
@ApiModel(value = "ReqUserInfo",description = "用户信息请求")
public class ReqUserInfo {
    @ApiModelProperty(value = "用户id")
    private String userId;

    public byte[] getBytes() {
        //设置输入的参数
        ClientMgr.ReqUserInfo.Builder builder = ClientMgr.ReqUserInfo.newBuilder();
        builder.setUserId(this.userId);
        ClientMgr.ReqUserInfo build = builder.build();
        byte[] bodyByteArray = build.toByteArray();
        //获取body的长度
        int bodyLen = bodyByteArray.length;
        int totalLen= MagicNo.headLen + bodyLen;
        //将头和前端传入字段传入ByteBuffer中
        ByteBuffer byteBuffer = ByteBuffer.allocate(totalLen);
        //将字节存入缓冲字节流中,设置为小端，Java默认的是大端
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN)
                .putInt(totalLen)
                .putInt(MsgId.MSG_QUERY_USER_INFO.getId())
                .putInt(RetCode.SUCCESS.getCode())
                .put(bodyByteArray);
        return byteBuffer.array();
    }
}
