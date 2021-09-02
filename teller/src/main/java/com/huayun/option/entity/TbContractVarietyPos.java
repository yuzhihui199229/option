package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 合约品种持仓表
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbContractVarietyPos对象", description="合约品种持仓表")
public class TbContractVarietyPos implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "事务ID")
    private Integer txId;

    @ApiModelProperty(value = "标的物ID")
    private Integer usecurityId;

    @ApiModelProperty(value = "持仓限额ID;初始化时要加载")
    private Integer uposLimitId;

    @ApiModelProperty(value = "股东账户ID")
    private Integer uaccountId;

    @ApiModelProperty(value = "权利仓持仓")
    private Long rightsPosQty;

    @ApiModelProperty(value = "总持仓")
    private Long positionQty;

    @ApiModelProperty(value = "单日买入量")
    private Long dayBuyQty;


}
