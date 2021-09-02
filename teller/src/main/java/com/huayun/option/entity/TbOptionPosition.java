package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 期权持仓表(MyISAM)
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbOptionPosition对象", description="期权持仓表(MyISAM)")
public class TbOptionPosition implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "用户ID")
    private Integer uuserId;

    @ApiModelProperty(value = "期权ID")
    private Integer uoptionId;

    @ApiModelProperty(value = "合约账户ID")
    private Integer uaccountId;

    @ApiModelProperty(value = "买持仓")
    private Long buyQty;

    @ApiModelProperty(value = "卖持仓")
    private Long sellQty;

    @ApiModelProperty(value = "备兑持仓")
    private Long coverQty;

    @ApiModelProperty(value = "买冻结仓")
    private Long buyFrozenQty;

    @ApiModelProperty(value = "卖冻结仓")
    private Long sellFrozenQty;

    @ApiModelProperty(value = "备兑冻结仓;买：权利仓，卖：义务仓")
    private Long coverFrozenQty;

    @ApiModelProperty(value = "买价格")
    private Double buyPrice;

    @ApiModelProperty(value = "卖价格")
    private Double sellPrice;

    @ApiModelProperty(value = "买入开仓数量")
    private Integer cumBuyQty;

    @ApiModelProperty(value = "卖出开仓数量")
    private Integer cumSellQty;

    @ApiModelProperty(value = "盈亏")
    private Double profitAndLoss;

    @ApiModelProperty(value = "收益率")
    private Double rateOfReturn;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;

    @ApiModelProperty(value = "版本号")
    private Integer vers;


}
