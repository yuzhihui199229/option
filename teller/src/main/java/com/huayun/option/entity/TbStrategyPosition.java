package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 组合策略持仓表
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbStrategyPosition对象", description="组合策略持仓表")
public class TbStrategyPosition implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "期权ID1")
    private Integer uoptionId1;

    @ApiModelProperty(value = "期权ID2")
    private Integer uoptionId2;

    @ApiModelProperty(value = "期权ID3")
    private Integer uoptionId3;

    @ApiModelProperty(value = "期权ID4")
    private Integer uoptionId4;

    @ApiModelProperty(value = "策略代码;1=CNSJC;2=CXSJC;3=PNSJC;4=PXSJC;5=KS;6=KKS")
    private String strategyType;

    @ApiModelProperty(value = "持仓数量")
    private Long posQty;

    @ApiModelProperty(value = "冻结持仓数量")
    private Long frozenQty;

    @ApiModelProperty(value = "期权1持仓ID")
    private Integer uposId1;

    @ApiModelProperty(value = "期权2持仓ID")
    private Integer uposId2;

    @ApiModelProperty(value = "期权3持仓ID")
    private Integer uposId3;

    @ApiModelProperty(value = "期权4持仓ID")
    private Integer uposId4;

    @ApiModelProperty(value = "股东账户ID")
    private Integer uaccountId;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;


}
