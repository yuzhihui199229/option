package com.huayun.option.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ReqOrderCancel",description = "撤单请求")
public class ReqOrderCanceled {
    @ApiModelProperty(value = "token,", dataType = "Char[32]", required = true)
    private String token;

    @ApiModelProperty(value = "msgType")
    private Integer msgType;

    @ApiModelProperty(value = "消息体长度")
    private Integer bodyLength;

    @ApiModelProperty(value = "应用标识",dataType = "char[3]",required = true)
    private String applID;

    @ApiModelProperty(value = "申报交易单元",dataType = "char[6]",required = true)
    private String submittingPBUID;

    @ApiModelProperty(value = "证券代码",dataType = "char[8]",required = true)
    private String securityID;

    @ApiModelProperty(value = "证券代码源，102=深圳证券交易所",dataType = "char[4]",required = true)
    private String SecurityIDSource;

    @ApiModelProperty(value = "订单所有者类型:1=个人投资者发起,101=交易所发起,102=会员发起,103=机构投资者发起,104=自营交易发起,105=流动性服务提供商发起,106=结算结构发起",required = true)
    private Short ownerType;

    @ApiModelProperty(value = "结算机构代码:00=中国证券登记结算总公司,01=中国证券登记结算公司深圳分公司,09=自建TA",dataType = "char[2]",required = true)
    private String clearingFirm;

    @ApiModelProperty(value = "委托时间")
    private Long transactTime;

    @ApiModelProperty(value = "用户私有信息",dataType = "char[8]")
    private String userInfo;

    @ApiModelProperty(value = "客户订单编号",dataType = "char[10]")
    private String clOrdID;

    @ApiModelProperty(value = "原始订单客户订单编号",dataType = "char[10]",required = true)
    private String origClOrdID;

    @ApiModelProperty(value = "买卖方向",dataType = "char",required = true)
    private String side;

    @ApiModelProperty(value = "原始订单交易所订单编号,交易所对该字段的值不作检查",dataType = "char[16]")
    private String orderID;

    @ApiModelProperty(value = "原始订单数量,交易所对该字段的值不作检查",required = true)
    private Long orderQty;

    @ApiModelProperty(value = "校验和")
    private Integer checksum;

    @ApiModelProperty(value = "申报交易单元整形编号",required = true)
    private Short pbuID;

    @ApiModelProperty(value = "证券帐户整形编号",required = true)
    private Integer accID;

    @ApiModelProperty(value = "证券代码整形编号",required = true)
    private Integer secID;

    @ApiModelProperty(value = "持仓整形编号")
    private Integer posID;

    @ApiModelProperty(value = "原订单整形编号",required = true)
    private Integer id;

}
