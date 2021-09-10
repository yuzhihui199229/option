package com.huayun.option.request;

import com.google.protobuf.ByteString;
import com.huayun.option.model.MagicNo;
import com.huayun.option.model.MsgId;
import com.huayun.option.protobuf.ClientMgr;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

@Data
@Accessors(chain = true)
@ApiModel(value = "ReqLoginZmq", description = "登录")
public class ReqLogin {
    @ApiModelProperty(value = "用户ID,", dataType = "Char[12]", required = true)
    private String userID;

    @ApiModelProperty(value = "用户密码,", dataType = "Char[32]", required = true)
    private String password;

    @ApiModelProperty(value = "客户端类型：可能的值为'0','1','2','3','4',", dataType = "Char", required = true)
    private String clientType;

    public byte[] getBytes() {
        //设置输入的参数
        ClientMgr.ReqLogin.Builder builder = ClientMgr.ReqLogin.newBuilder();
        builder.setUserId(this.userID)
                .setPassword(this.password)
                .setClientType(ByteString.copyFrom("1",StandardCharsets.UTF_8));
        ClientMgr.ReqLogin build = builder.build();
        byte[] bodyByteArray = build.toByteArray();
        //获取body的长度
        int bodyLen = bodyByteArray.length;
        int totalLen= MagicNo.headLen + bodyLen;
        //将头和前端传入字段传入ByteBuffer中
        ByteBuffer byteBuffer = ByteBuffer.allocate(totalLen);
        //将字节存入缓冲字节流中,设置为小端，Java默认的是大端
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN)
                .putInt(totalLen)
                .putInt(MsgId.MSG_LOGIN.getId())
                .putInt(0)
                .put(bodyByteArray);
        return byteBuffer.array();
    }

}
