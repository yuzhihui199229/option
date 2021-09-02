package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 费率配置表(MyISAM)
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbFeeRateConfig对象", description="费率配置表(MyISAM)")
public class TbFeeRateConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "基数区间下限")
    private Double baseLower;

    @ApiModelProperty(value = "费用;, 优先级高于fee_rate")
    private Double fee;

    @ApiModelProperty(value = "费率")
    private Integer feeRate;

    @ApiModelProperty(value = "用户费率组")
    private Integer feeGroup;

    @ApiModelProperty(value = "费率类型;0：手续费，1：过户费，3：印花税")
    private Integer feeType;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;

    @ApiModelProperty(value = "版本号")
    private Integer vers;


}
