package com.huayun.option.response;

import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "RspOrderCancel", description = "撤单响应")
public class RspOrderCancel extends BaseCodecResponse<RspOrderCancel> {
    @ApiModelProperty(value = "客户订单编号")
    private String ClOrdID;

    @ApiModelProperty(value = "版本号")
    private Integer version;

    @Override
    RspOrderCancel parseResponse(ByteBuf byteBuf) {
        ClOrdID = (String) byteBuf.readCharSequence(10, CharsetUtil.UTF_8);
        version = byteBuf.readIntLE();
        return this;
    }
}
