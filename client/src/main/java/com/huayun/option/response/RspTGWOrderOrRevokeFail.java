package com.huayun.option.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "RspTGWOrderOrRevokeFail", description = "交易所订单响应及撤单失败响应接口")
public class RspTGWOrderOrRevokeFail {

    @ApiModelProperty(value = "消息类型")
    private Integer msgType;

    @ApiModelProperty(value = "消息体长度")
    private Integer bodyLength;

    @ApiModelProperty(value = "平台分区号")
    private Integer partitionNo;

    @ApiModelProperty(value = "回报记录号")
    private Long reportIndex;

    @ApiModelProperty(value = "应用标识", dataType = "char[3]")
    private String applID;

    @ApiModelProperty(value = "回报交易单元", dataType = "char[6]")
    private String reportingPBUID;

    @ApiModelProperty(value = "申报交易单元", dataType = "char[6]")
    private String submittingPBUID;

    @ApiModelProperty(value = "证券代码", dataType = "char[8]")
    private String securityID;

    @ApiModelProperty(value = "证券代码源，102=深圳证券交易所", dataType = "char[4]")
    private String securityIDSource;

    @ApiModelProperty(value = "订单所有者类型，1=个人投资者发起，101=交易所发起，102=会员发起，103=机构投资者发起，104=自营交易发起，105=流动性服务提供商发起，106=结算结构发起")
    private Short ownerType;

    @ApiModelProperty(value = "结算机构代码:00=中国证券登记结算总公司,01=中国证券登记结算公司深圳分公司,09=自建TA", dataType = "char[2]")
    private String clearingFirm;

    @ApiModelProperty(value = "委托时间")
    private Long transactTime;

    @ApiModelProperty(value = "用户私有信息", dataType = "char[8]")
    private String userInfo;

    @ApiModelProperty(value = "客户订单编号", dataType = "char[10]")
    private String clOrdID;

    @ApiModelProperty(value = "原始订单客户订单编号", dataType = "char[10]")
    private String origClOrdID;

    @ApiModelProperty(value = "买卖方向;1= 买,2= 卖,G= 借入,F= 出借,D= 申购,E= 赎回",dataType = "char")
    private String side;

    @ApiModelProperty(value = "原始订单当前状态:如果未找到原始订单，则填8=Rejected",dataType = "char")
    private String ordStatus;

    @ApiModelProperty(value = "拒绝原因代码")
    private Short cxlRejReason;

    @ApiModelProperty(value = "拒绝原因说明",dataType = "char[16]")
    private String RejectText;

    @ApiModelProperty(value = "原始订单交易所订单编号",dataType = "char[16]")
    private String orderID;

    @ApiModelProperty(value = "校验和")
    private Integer checksum;
}
