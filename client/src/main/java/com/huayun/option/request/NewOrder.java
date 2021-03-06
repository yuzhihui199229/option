package com.huayun.option.request;

import com.huayun.option.utils.ByteBufUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "NewOrder",description = "OMS向TGW报送新订单")
public class NewOrder {

    @ApiModelProperty(value = "消息类型")
    private Integer msgType;

    @ApiModelProperty(value = "消息体长度")
    private Integer bodyLength;

    @ApiModelProperty(value = "应用标识", dataType = "Char[3]", required = true)
    private String applID;

    @ApiModelProperty(value = "申报交易单元", dataType = "Char[6]", required = true)
    private String submittingPBUID;

    @ApiModelProperty(value = "证券代码", dataType = "Char[8]", required = true)
    private String securityID;

    @ApiModelProperty(value = "证券代码源，102=深圳证券交易所", dataType = "Char[4]", required = true)
    private String securityIDSource;

    @ApiModelProperty(value = "订单所有者类型:1=个人投资者发起,101=交易所发起,102=会员发起,103=机构投资者发起,104=自营交易发起,105=流动性服务提供商发起,106=结算结构发起",
            dataType = "Char[4]", required = true)
    private Short ownerType;

    @ApiModelProperty(value = "结算机构代码:00=中国证券登记结算总公司,01=中国证券登记结算公司深圳分公司,09=自建TA",dataType = "Char[2]",required = true)
    private String clearingFirm;

    @ApiModelProperty(value = "委托时间")
    private Long transactTime;

    @ApiModelProperty(value = "用户私有信息",dataType = "Char[8]")
    private String userInfo;

    @ApiModelProperty(value = "客户订单编号",dataType = "Char[10]")
    private String clOrdID;

    @ApiModelProperty(value = "原始订单客户订单编号",dataType = "char[10]",required = true)
    private String origClOrdID;

    @ApiModelProperty(value = "买卖方向:1= 买,2= 卖,G= 借入,F= 出借,D= 申购,E= 赎回",dataType = "char",required = true)
    private String side;

    @ApiModelProperty(value = "原始订单交易所订单编号,交易所对该字段的值不作检查",dataType = "Char[16]")
    private String orderID;

    @ApiModelProperty(value = "原始订单数量,交易所对该字段的值不作检查",required = true)
    private Long orderQty;

    @ApiModelProperty(value = "校验和")
    private Integer checksum;

    public ByteBuf formatNewOrder() {
        ByteBuf byteBuf = Unpooled.buffer();
        byteBuf.writeIntLE(msgType);
        byteBuf.writeIntLE(bodyLength);
        ByteBufUtil.writeCharSequence(byteBuf,applID,3);
        ByteBufUtil.writeCharSequence(byteBuf,submittingPBUID,6);
        ByteBufUtil.writeCharSequence(byteBuf,securityID,8);
        ByteBufUtil.writeCharSequence(byteBuf,securityIDSource,4);
        byteBuf.writeShortLE(ownerType);
        ByteBufUtil.writeCharSequence(byteBuf,clearingFirm,2);
        byteBuf.writeLongLE(transactTime);
        ByteBufUtil.writeCharSequence(byteBuf,userInfo,8);
        ByteBufUtil.writeCharSequence(byteBuf,clOrdID,10);
        ByteBufUtil.writeCharSequence(byteBuf,origClOrdID,10);
        ByteBufUtil.writeCharSequence(byteBuf,side,1);
        ByteBufUtil.writeCharSequence(byteBuf,orderID,16);
        byteBuf.writeLongLE(orderQty);
        byteBuf.writeIntLE(checksum);
        return byteBuf;
    }
}
