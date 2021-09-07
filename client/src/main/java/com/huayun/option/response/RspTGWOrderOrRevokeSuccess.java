package com.huayun.option.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "RspTGWOrderOrRevokeSuccess", description = "交易所订单响应及撤单成功响应接口")
public class RspTGWOrderOrRevokeSuccess {

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

    @ApiModelProperty(value = "交易所订单编号", dataType = "char[16]")
    private String orderID;

    @ApiModelProperty(value = "客户订单编号", dataType = "char[10]")
    private String clOrdID;

    @ApiModelProperty(value = "原始订单客户订单编号", dataType = "char[10]")
    private String origClOrdID;

    @ApiModelProperty(value = "执行编号",dataType = "char[16]")
    private String execID;

    @ApiModelProperty(value = "执行类型:0=New，表示新订单,4=Cancelled，表示已撤销,8=Reject，表示已拒绝,F=Trade，表示已成交",dataType = "char")
    private String execType;

    @ApiModelProperty(value = "订单状态:0=New，表示新订单,1=Partially filled，表示部分成交,2=Filled，表示全部成交,4=Cancelled，表示已撤销,8=Reject，表示已拒绝",dataType = "char")
    private String ordStatus;

    @ApiModelProperty(value = "撤单/拒绝原因代码")
    private Short ordRejReason;

    @ApiModelProperty(value = "订单剩余数量")
    private Long leavesQty;

    @ApiModelProperty(value = "累计执行数量")
    private Long CumQty;

    @ApiModelProperty(value = "买卖方向;1= 买,2= 卖,G= 借入,F= 出借,D= 申购,E= 赎回",dataType = "char")
    private String side;

    @ApiModelProperty(value = "订单类别:1表示市价,2 表示限价,U 本方最优", dataType = "char")
    private String ordType;

    @ApiModelProperty(value = "价格")
    private Long price;

    @ApiModelProperty(value = "证券帐户",dataType = "char[12]")
    private String accountID;

    @ApiModelProperty(value = "营业部代码",dataType = "char[4]")
    private String branchID;

    @ApiModelProperty(value = "订单限定:1=程序化交易,E=算法交易,最多可同时填写四种限定类型,如没有则填空",dataType = "char[4]")
    private String orderRestrictions;

    @ApiModelProperty(value = "止损价")
    private Long stopPx;

    @ApiModelProperty(value = "最低成交数量")
    private Long minQty;

    @ApiModelProperty(value = "最多成交价位数:0 表示不限制成交价位数")
    private Short maxPriceLevels;

    @ApiModelProperty(value = "订单有效时间类型", dataType = "char")
    private String timeInForce;

    @ApiModelProperty(value = "平仓标识:‘O’ 开仓， ‘C’ 平仓", dataType = "char")
    private String positionEffect;

    @ApiModelProperty(value = "备兑标签", dataType = "0=Covered， 表示备兑,1=uncovered， 表示非备兑")
    private Byte coveredOrUncovered;

    @ApiModelProperty(value = "合约帐户标识码",dataType = "char[6]")
    private String contractAccountcode;

    @ApiModelProperty(value = "校验和")
    private Integer checksum;
}
