package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 行权记录表
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbExerciseRecord对象", description="行权记录表")
public class TbExerciseRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "用户ID")
    private Integer uuserId;

    @ApiModelProperty(value = "合约账户标识码")
    private String contractAccountCode;

    @ApiModelProperty(value = "证券代码")
    private String securityId;

    @ApiModelProperty(value = "交易所订单编码")
    private String orderId;

    @ApiModelProperty(value = "原始客户订单编号")
    private String origClOrdId;

    @ApiModelProperty(value = "订单状态")
    private Integer orderStatus;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;


}
