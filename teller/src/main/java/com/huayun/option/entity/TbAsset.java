package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 资金流水表
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbAsset对象", description="资金流水表")
public class TbAsset implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "事务ID")
    private Long id;

    @ApiModelProperty(value = "期权ID")
    private Integer uoptionId;

    @ApiModelProperty(value = "合约账户ID")
    private Integer uaccountId;

    @ApiModelProperty(value = "持仓ID")
    private Integer uposId;

    @ApiModelProperty(value = "组合策略持仓ID")
    private Integer ustrategyPosId;

    @ApiModelProperty(value = "执行编号")
    private String execId;

    @ApiModelProperty(value = "成交余额")
    private Double fromBalance;

    @ApiModelProperty(value = "成交冻结")
    private Double fromFrozen;

    @ApiModelProperty(value = "成交余额")
    private Double toBalance;

    @ApiModelProperty(value = "成交冻结")
    private Double toFrozen;

    @ApiModelProperty(value = "资金交易类型;0:buy, 1:sell, 2:in, 3:out, 4:frozen, 5:unfrozen")
    private Integer tradeType;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;


}
