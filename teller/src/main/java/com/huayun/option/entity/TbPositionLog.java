package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 期权持仓流水表(MyISAM)
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbPositionLog对象", description="期权持仓流水表(MyISAM)")
public class TbPositionLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "事务ID")
    private Integer txId;

    @ApiModelProperty(value = "期权持仓ID")
    private Integer uposId;

    @ApiModelProperty(value = "组合策略持仓ID")
    private Integer ustrategyPosId;

    @ApiModelProperty(value = "用户ID")
    private Integer uuserId;

    @ApiModelProperty(value = "期权ID")
    private Integer uoptionId;

    @ApiModelProperty(value = "期权账户ID")
    private Integer uaccountId;

    @ApiModelProperty(value = "前买持仓")
    private Long fromBuyQty;

    @ApiModelProperty(value = "前卖持仓")
    private Long fromSellQty;

    @ApiModelProperty(value = "前备兑持仓")
    private Long fromCoverQty;

    @ApiModelProperty(value = "前买冻结仓")
    private Long fromBuyFrozenQty;

    @ApiModelProperty(value = "前卖冻结仓")
    private Long fromSellFrozenQty;

    @ApiModelProperty(value = "前备兑冻结仓;买：权利仓，卖：义务仓")
    private Long fromCoverFrozenQty;

    @ApiModelProperty(value = "后买持仓")
    private Long toBuyQty;

    @ApiModelProperty(value = "后卖持仓")
    private Long toSellQty;

    @ApiModelProperty(value = "后备兑持仓")
    private Long toCoverQty;

    @ApiModelProperty(value = "后买冻结仓")
    private Long toBuyFrozenQty;

    @ApiModelProperty(value = "后卖冻结仓")
    private Long toSellFrozenQty;

    @ApiModelProperty(value = "后备兑冻结仓")
    private Long toCoverFrozenQty;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;


}
