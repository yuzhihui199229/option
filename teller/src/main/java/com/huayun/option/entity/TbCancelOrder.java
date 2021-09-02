package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 撤单表(MyISAM)
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbCancelOrder对象", description="撤单表(MyISAM)")
public class TbCancelOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "应用标识")
    private String applId;

    @ApiModelProperty(value = "申报交易单元")
    private String submittingPbuid;

    @ApiModelProperty(value = "证券代码")
    private String securityId;

    @ApiModelProperty(value = "证券代码源")
    private String securityIdSource;

    @ApiModelProperty(value = "订单所有者类型")
    private Integer ownerType;

    @ApiModelProperty(value = "结算机构代码")
    private String clearingFirm;

    @ApiModelProperty(value = "委托时间")
    private Long transactTime;

    @ApiModelProperty(value = "用户私有信息")
    private String userInfo;

    @ApiModelProperty(value = "客户订单编号")
    private String clOrdId;

    @ApiModelProperty(value = "原始订单客户编号")
    private String origClOrdId;

    @ApiModelProperty(value = "原始订单买卖方向")
    private Integer side;

    @ApiModelProperty(value = "原订单TGW订单编号")
    private String orderId;

    @ApiModelProperty(value = "原始订单数量")
    private Long orderQty;

    @ApiModelProperty(value = "事务ID")
    private Integer txId;

    @ApiModelProperty(value = "客户端sequence")
    private Integer seq;

    @ApiModelProperty(value = "用户ID")
    private Integer uuserId;

    @ApiModelProperty(value = "股东账户ID")
    private Integer uaccountId;

    @ApiModelProperty(value = "期权ID")
    private Integer uoptionId;

    @ApiModelProperty(value = "持仓ID")
    private Integer uposId;


}
