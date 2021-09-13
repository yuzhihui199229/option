package com.huayun.option.request;

import com.huayun.option.model.MagicNo;
import com.huayun.option.model.MsgId;
import com.huayun.option.protobuf.ClientMgr;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@Data
@Accessors(chain = true)
@ApiModel(value = "ReqAssetInfoAndOptionPosition", description = "资金信息和期权持仓公共请求")
public class ReqAssetInfoAndOptionPosition implements BaseRequest{

    @ApiModelProperty(value = "token",required = true)
    private String  token;

    @ApiModelProperty(value = "用户id",required = true)
    private Integer  uuserId;

    /**
     * 将请求的参数转化为字节数组
     * @return
     */
    @Override
    public byte[] formatRequest() {
        //设置输入的参数
        ClientMgr.ReqSelInterface.Builder builder = ClientMgr.ReqSelInterface.newBuilder();
        builder.setToken(this.token);
        ClientMgr.ReqSelInterface    build = builder.build();
        byte[] bodyByteArray = build.toByteArray();
        //获取body的长度
        int bodyLen = bodyByteArray.length;
        int totalLen= MagicNo.headLen + bodyLen;
        //将头和前端传入字段传入ByteBuffer中
        ByteBuffer byteBuffer = ByteBuffer.allocate(totalLen);
        //将字节存入缓冲字节流中,设置为小端，Java默认的是大端
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN)
                .putInt(totalLen)
                .putInt(MsgId.MSG_QUERY_ASSET.getId())
                .putInt(this.uuserId)
                .put(bodyByteArray);
        return byteBuffer.array();
    }
}
