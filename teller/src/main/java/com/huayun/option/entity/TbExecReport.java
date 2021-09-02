package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 成交回执表(MyISAM)
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbExecReport对象", description="成交回执表(MyISAM)")
public class TbExecReport implements Serializable {

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
    private String submitingPubid;

    @ApiModelProperty(value = "证券代码")
    private String securityId;

    @ApiModelProperty(value = "证券代码源")
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

    @ApiModelProperty(value = "客户订单编号")
    private String clOrdId;

    @ApiModelProperty(value = "执行编号")
    private String execId;

    @ApiModelProperty(value = "执行类型")
    private Integer execType;

    @ApiModelProperty(value = "订单状态")
    private Integer ordStatus;

    @ApiModelProperty(value = "成交价")
    private Long lastPx;

    @ApiModelProperty(value = "成交数量")
    private Long lastQty;

    @ApiModelProperty(value = "订单剩余数量")
    private Long leavesQty;

    @ApiModelProperty(value = "累计执行数量")
    private Long cumQty;

    @ApiModelProperty(value = "买卖反向")
    private Integer side;

    @ApiModelProperty(value = "证券账户")
    private String accountId;

    @ApiModelProperty(value = "营业部代码")
    private String branchId;

    @ApiModelProperty(value = "平仓标识;O开仓， C平仓")
    private Integer positionEffect;

    @ApiModelProperty(value = "备兑标签;0备兑，1非备兑")
    private Integer coveredOrUncovered;

    @ApiModelProperty(value = "合约账户标识")
    private String contractAccountCode;

    @ApiModelProperty(value = "校验和")
    private Integer checkSum;

    @ApiModelProperty(value = "事务ID")
    private Integer txId;

    @ApiModelProperty(value = "订单ID")
    private Integer uorderId;

    @ApiModelProperty(value = "用户ID")
    private Integer uuserId;

    @ApiModelProperty(value = "交易网关ID")
    private Integer ugwAddrId;


}
