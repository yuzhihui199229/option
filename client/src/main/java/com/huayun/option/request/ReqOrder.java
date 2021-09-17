package com.huayun.option.request;

import com.huayun.option.codec.HeadCodec;
import com.huayun.option.codec.ProtocolCodec;
import com.huayun.option.protobuf.Head;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.IOException;

@Data
@Accessors(chain = true)
@ApiModel(value = "ReqOrder", description = "订单请求")
public class ReqOrder extends BaseCodecRequest {
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

    @ApiModelProperty(value = "原订单整形编号", required = true)
    private Integer id;


    @Override
    public ProtocolCodec formatRequest() throws IOException {
        HeadCodec headCodec = new HeadCodec();
        headCodec.setMagicNum((short) 0)
                .setVersion("")
                .setMsgType("")
                .setSourceId((short) 0)
                .setSessionId(0)
                .setFuncNo((short) 0)
                .setMsgLen(0)
                .setMsgSeq(0)
                .setRetCode(0)
                .setMktCode(0L);
        return null;
    }
}
