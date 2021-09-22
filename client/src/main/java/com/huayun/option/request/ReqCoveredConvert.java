package com.huayun.option.request;

import com.huayun.option.codec.HeadCodec;
import com.huayun.option.codec.ProtocolCodec;
import com.huayun.option.utils.ByteBufUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ReqCoveredTurned",description = "备兑开平仓与互转请求")
public class ReqCoveredConvert  extends BaseCodecRequest {

    @ApiModelProperty(value = "token",dataType = "char[32]",required = true)
    private String token;

    @ApiModelProperty(value = "新订单公共部分",dataType = "NewOrder",required = true)
    private NewOrder newOrder;

    @ApiModelProperty(value = "合约账户标识码",dataType = "char[6]",required = true)
    private String conTractAcctCode;

    @ApiModelProperty(value = "校验和",required = true)
    private Integer checkSum;

    @ApiModelProperty(value = "交易单元ID",required = true)
    private Short pbuID;

    @ApiModelProperty(value = "合约账户ID",required = true)
    private Integer accID;

    @ApiModelProperty(value = "资金账户ID")
    private Integer assetID;

    @ApiModelProperty(value = "期权账户ID",required = true)
    private Integer optionID;

    @ApiModelProperty(value = "期权持仓ID",required = true)
    private Integer posID;

    @Override
    public ProtocolCodec formatRequest(int uuserId, int sessionId) {
        ByteBuf body = Unpooled.buffer();
        ByteBufUtil.writeCharSequence(body, token, 32);
        body.writeBytes(newOrder.formatNewOrder());
        ByteBufUtil.writeCharSequence(body,conTractAcctCode,6);
        body.writeIntLE(checkSum);
        body.writeShortLE(pbuID);
        body.writeIntLE(accID);
        body.writeIntLE(optionID);
        body.writeIntLE(posID);
        HeadCodec headCodec = new HeadCodec();
        headCodec.setMagicNum((short) 0XDADA)
                .setVersion("1")
                .setMsgType("1")
                .setSourceId((short) 0x1000)
                .setSessionId(sessionId)
                .setFuncNo((short) 0x7010)
                .setMsgLen(32 + body.capacity())
                .setMsgSeq(0)
                .setRetCode(uuserId)
                .setMktCode(0L);
        ProtocolCodec protocolCodec = new ProtocolCodec();
        protocolCodec.setHeadCodec(headCodec)
                .setBody(body);
        return protocolCodec;
    }

}
