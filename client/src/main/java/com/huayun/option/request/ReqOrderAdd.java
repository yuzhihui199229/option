package com.huayun.option.request;

import com.huayun.option.codec.HeadCodec;
import com.huayun.option.codec.ProtocolCodec;
import com.huayun.option.utils.ByteBufUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "ReqOrder", description = "订单请求")
public class ReqOrderAdd extends BaseCodecRequest {
    @ApiModelProperty(value = "token,", dataType = "Char[32]", required = true)
    private String token;

    @ApiModelProperty(value = "新订单公共实体类,", dataType = "NewOrder", required = true)
    private NewOrder newOrder;

    @ApiModelProperty(value = "申报交易单元整形编号", required = true)
    private Short pbuID;

    @ApiModelProperty(value = "证券帐户整形编号", required = true)
    private Integer accID;

    @ApiModelProperty(value = "证券代码整形编号", required = true)
    private Integer secID;

    @ApiModelProperty(value = "持仓整形编号")
    private Integer posID;


    @Override
    public ProtocolCodec formatRequest(int uuserId,int sessionId) {
        ProtocolCodec protocolCodec=new ProtocolCodec();
        ByteBuf body = Unpooled.buffer();
        ByteBufUtil.writeCharSequence(body,token,32);
        body.writeShortLE(pbuID);
        body.writeIntLE(accID);
        body.writeIntLE(secID);
        body.writeIntLE(posID);
        body.writeBytes(newOrder.formatNewOrder());
        HeadCodec headCodec = new HeadCodec();
        headCodec.setMagicNum((short) 0XDADA)
                .setVersion("1")
                .setMsgType("1")
                .setSourceId((short) 0x1000)
                .setSessionId(sessionId)
                .setFuncNo((short) 0x7010)
                .setMsgLen(32+body.capacity())
                .setMsgSeq(0)
                .setRetCode(uuserId)
                .setMktCode(0L);
        return protocolCodec;
    }
}
