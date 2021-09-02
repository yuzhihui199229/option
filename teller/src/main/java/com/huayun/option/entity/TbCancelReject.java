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
@ApiModel(value="TbCancelReject对象", description="成交回执表(MyISAM)")
public class TbCancelReject implements Serializable {

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

    @ApiModelProperty(value = "客户订单编号")
    private String clOrdId;

    @ApiModelProperty(value = "原始客户订单编号")
    private String origClOrdId;

    @ApiModelProperty(value = "买卖反向")
    private Integer side;

    @ApiModelProperty(value = "原始订单当前状态")
    private Integer ordStatus;

    @ApiModelProperty(value = "拒绝原因代码")
    private Integer cxlRejReason;

    @ApiModelProperty(value = "拒绝原因说明")
    private String rejectText;

    @ApiModelProperty(value = "原订单TGW订单编号")
    private String orderId;

    @ApiModelProperty(value = "事务ID")
    private Integer txId;

    @ApiModelProperty(value = "订单ID")
    private Integer uorderId;

    @ApiModelProperty(value = "股东账户ID")
    private Integer uaccountId;

    @ApiModelProperty(value = "用户ID")
    private Integer uuserId;

    @ApiModelProperty(value = "交易网关ID")
    private Integer ugwAddrId;


}
