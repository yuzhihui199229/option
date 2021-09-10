package com.huayun.option.response;

import com.google.protobuf.InvalidProtocolBufferException;
import com.huayun.option.protobuf.ClientMgr;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value = "RspLoginZmq", description = "登录应答")
public class RspLogin {

    @ApiModelProperty(value = "token,", dataType = "Char[32]")
    private String token;

    @ApiModelProperty(value = "sessionId")
    private Integer id;

    @ApiModelProperty(value = "用户ID,", dataType = "Char[12]", required = true)
    private Integer uuserID;

    /**
     * 将字节码数组转化为RspLogin
     * @param bytes
     * @return
     * @throws InvalidProtocolBufferException
     */
    public RspLogin getRspLogin(byte[] bytes) throws InvalidProtocolBufferException {
        //将字节码数组通过protobuf转化
        ClientMgr.RspLogin rspLoginProto = ClientMgr.RspLogin.parseFrom(bytes);
        //将ClientMgr.RspLogin中的数据封装到RspLogin中
        RspLogin rspLogin = new RspLogin();
        rspLogin.setToken(rspLoginProto.getToken())
                .setId(rspLoginProto.getId())
                .setUuserID(rspLoginProto.getUuserId());
        return rspLogin;
    }

}
