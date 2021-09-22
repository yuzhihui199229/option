package com.huayun.option.response;

import com.huayun.option.request.BaseCodecRequest;
import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "RspCoveredTurned",description = "备兑开平仓与互转应答")
public class RspCoveredConvert extends BaseCodecResponse<RspCoveredConvert> {

    @ApiModelProperty(value = "客户订单编号对应整型ID")
    private Integer id;

    @ApiModelProperty(value = "客户订单编号",dataType = "char[10]")
    private String  clOrdID;

    @ApiModelProperty(value = "订单状态")
    private String ordStatus;

    @ApiModelProperty(value = "版本信息，保留")
    private Integer version;

    @Override
    RspCoveredConvert parseResponse(ByteBuf byteBuf) {
        this.id = byteBuf.readIntLE();
        this.clOrdID = (String)byteBuf.readCharSequence(10, CharsetUtil.UTF_8);
        this.ordStatus = (String)byteBuf.readCharSequence(1, CharsetUtil.UTF_8);
        this.version = byteBuf.readIntLE();
        return this;
    }
}
