package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 费率记录操作表(MyISAM)
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbFeeRateOperRecord对象", description="费率记录操作表(MyISAM)")
public class TbFeeRateOperRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "费率ID")
    private Integer feeRateId;

    @ApiModelProperty(value = "操作类型;0增加，1修改，2删除")
    private Integer operType;

    @ApiModelProperty(value = "操作时间")
    private Long operTime;

    @ApiModelProperty(value = "操作说明")
    private String content;


}
