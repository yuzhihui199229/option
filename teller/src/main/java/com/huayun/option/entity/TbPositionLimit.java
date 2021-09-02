package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 持仓限额配置表
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbPositionLimit对象", description="持仓限额配置表")
public class TbPositionLimit implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "标的物ID")
    private Integer usecurityId;

    @ApiModelProperty(value = "股东账户ID;默认值为0，表示通配所有")
    private Integer uaccountId;

    @ApiModelProperty(value = "持仓等级;分为4级")
    private Integer posLevel;

    @ApiModelProperty(value = "单权利仓持仓限额")
    private Long rightsPosLimitQty;

    @ApiModelProperty(value = "总持仓限额")
    private Long positionLimitQty;

    @ApiModelProperty(value = "单日买入开仓限额")
    private Long dayBuyLimitQty;


}
