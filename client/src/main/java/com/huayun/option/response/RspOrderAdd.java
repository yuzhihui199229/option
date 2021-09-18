package com.huayun.option.response;

import com.huayun.option.codec.ProtocolCodec;
import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "RspOrderAdd",description = "订单响应")
public class RspOrderAdd {

    @ApiModelProperty(value = "整型订单编号")
    private Integer id;

    @ApiModelProperty(value = "客户订单编号",dataType = "char[10]")
    private String clOrdID;

    @ApiModelProperty(value = "订单状态",dataType = "char")
    private  String OrdStatus;

    @ApiModelProperty(value = "版本号")
    private Integer version;

    public RspOrderAdd parseResponse(ByteBuf byteBuf) {
        id = byteBuf.readIntLE();
        clOrdID = (String) byteBuf.readCharSequence(10, CharsetUtil.UTF_8);
        OrdStatus = (String) byteBuf.readCharSequence(1, CharsetUtil.UTF_8);
        version = byteBuf.readIntLE();
        return null;
    }
}
