package com.huayun.option.response;

import com.google.protobuf.InvalidProtocolBufferException;
import com.huayun.option.protobuf.ClientMgr;
import com.huayun.option.protobuf.Protocol;
import com.huayun.option.utils.ProtoJsonUtil;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.IOException;

@ApiModel(value = "RspSelAssetInfo",description = "资金信息响应")
public class RspSelAssetInfo extends BaseResponse {
//    private Integer id;
//
//    @ApiModelProperty(value = "保证金账户")
//    private String assetAccount;
//
//    @ApiModelProperty(value = "用户ID")
//    private Integer uuserId;
//
//    @ApiModelProperty(value = "日间余额")
//    private Double balance;
//
//    @ApiModelProperty(value = "冻结资金")
//    private Double frozen;
//
//    @ApiModelProperty(value = "实时保证金")
//    private Double marginAmount;
//
//    @ApiModelProperty(value = "注册时间")
//    private Long createTime;
//
//    @ApiModelProperty(value = "更新时间")
//    private Long updateTime;
//
//    @ApiModelProperty(value = "资金版本号")
//    private Integer vers;

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
        ClientMgr.RspSelAssetInfo protobuf = ClientMgr.RspSelAssetInfo.parseFrom(bodyBytes);
        //protobuf转化为json
        String body = ProtoJsonUtil.toJson(protobuf);
        protocol.setBody(body);
        return protocol;
    }

}
