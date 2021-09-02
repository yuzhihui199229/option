package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 确认或撤销回执表(MyISAM)
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbOrderConfirm对象", description="确认或撤销回执表(MyISAM)")
public class TbOrderConfirm implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "平台分区号")
    private Integer partitionNo;

    @ApiModelProperty(value = "回报记录号")
    private Long reportIndex;

    @ApiModelProperty(value = "应用标识")
    private String applId;

    @ApiModelProperty(value = "回报交易单元")
    private String reportingPbuid;

    @ApiModelProperty(value = "申报交易单元")
    private String submitingPbuid;

    @ApiModelProperty(value = "证券代码")
    private String securityId;

    @ApiModelProperty(value = "证券代码源;102=深圳证券交易所")
    private String securityIdSource;

    @ApiModelProperty(value = "订单所有者类型")
    private Integer ownerType;

    @ApiModelProperty(value = "结算机构代码")
    private String clearingFirm;

    @ApiModelProperty(value = "回报时间")
    private Long transactTime;

    @ApiModelProperty(value = "用户信息")
    private String userInfo;

    @ApiModelProperty(value = "交易所订单编号")
    private String orderId;

    @ApiModelProperty(value = "客户订单号")
    private String clOrdId;

    @ApiModelProperty(value = "原订单客户订单编号")
    private String origClOrdId;

    @ApiModelProperty(value = "执行编号")
    private String execId;

    @ApiModelProperty(value = "执行类型")
    private Integer execType;

    @ApiModelProperty(value = "订单状态")
    private Integer ordStatus;

    @ApiModelProperty(value = "撤单/拒绝原因代码")
    private Integer ordRejReason;

    @ApiModelProperty(value = "订单剩余数量")
    private Long leavesQty;

    @ApiModelProperty(value = "累计执行数量")
    private Long cumQty;

    @ApiModelProperty(value = "买卖方向")
    private Integer side;

    @ApiModelProperty(value = "订单类别")
    private Integer ordType;

    @ApiModelProperty(value = "订单数量")
    private Long orderQty;

    @ApiModelProperty(value = "价格")
    private Long price;

    @ApiModelProperty(value = "证券账户")
    private String accountId;

    @ApiModelProperty(value = "营业部代码")
    private String branchId;

    @ApiModelProperty(value = "订单限定")
    private String orderRestrictions;

    @ApiModelProperty(value = "止损价")
    private Long stopPx;

    @ApiModelProperty(value = "最低成交数量")
    private Long minQty;

    @ApiModelProperty(value = "最多成交位数;0表示不限制")
    private Integer maxPriceLevels;

    @ApiModelProperty(value = "订单有效时间类型")
    private Integer timeInForce;

    @ApiModelProperty(value = "平仓标识;O开仓，C平仓")
    private Integer positionEffect;

    @ApiModelProperty(value = "备兑标签;0备兑，1非备兑")
    private Integer coveredOrUncovered;

    @ApiModelProperty(value = "合约账户标识码")
    private String contractAccountCode;

    @ApiModelProperty(value = "校验和")
    private Integer checkSum;

    @ApiModelProperty(value = "订单ID")
    private Integer uorderId;

    @ApiModelProperty(value = "事务ID")
    private Integer txId;

    @ApiModelProperty(value = "用户ID")
    private Integer uuserId;

    @ApiModelProperty(value = "交易网关ID")
    private Integer ugwAddrId;

    @ApiModelProperty(value = "原始订单ID(撤单)")
    private Integer uoriginOrdId;


}
