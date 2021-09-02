package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 证券信息表(MyISAM)
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbSecurityInfo对象", description="证券信息表(MyISAM)")
public class TbSecurityInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "证券代码")
    private String securityId;

    @ApiModelProperty(value = "证券代码源")
    private String securityIdSource;

    @ApiModelProperty(value = "证券代码")
    private String securityName;

    @ApiModelProperty(value = "前收盘价")
    private Double prevClosePx;

    @ApiModelProperty(value = "证券状态;0正常，1停盘，2退市")
    private Integer securityStatus;

    @ApiModelProperty(value = "限价买入上限")
    private Integer buyQtyUpperLimit;

    @ApiModelProperty(value = "限价卖出上限")
    private Integer sellQtyUpperLimit;

    @ApiModelProperty(value = "市价买入上限")
    private Integer marketBuyQtyUnit;

    @ApiModelProperty(value = "市价卖出上限")
    private Integer marketSellQtyUnit;

    @ApiModelProperty(value = "存在价格现在")
    private Integer hasPriceLimit;

    @ApiModelProperty(value = "价格限制类型")
    private Integer limitType;

    @ApiModelProperty(value = "价格上涨比例限制")
    private Double limitUpRate;

    @ApiModelProperty(value = "价格下跌比例限制")
    private Double limitDownRate;

    @ApiModelProperty(value = "价格上涨绝对值")
    private Double limitUpperAbsolute;

    @ApiModelProperty(value = "价格下跌绝对值")
    private Double limitDownAbsolute;

    @ApiModelProperty(value = "价格上涨限制值")
    private Double upperLimitPrice;

    @ApiModelProperty(value = "价格下跌限制值")
    private Double lowLimitPrice;

    @ApiModelProperty(value = "手续费")
    private Integer feeRate;

    @ApiModelProperty(value = "交易时间组")
    private Integer tradeTimeGroup;

    @ApiModelProperty(value = "ST当用户日买入上限;，已乘以100")
    private Integer cumBuyUpper;

    @ApiModelProperty(value = "股票板块属性")
    private Integer property;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;


}
