package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * ID配置表(MyISAM)
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbIdConfig对象", description="ID配置表(MyISAM)")
public class TbIdConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "记录ID名称")
    private String idName;

    @ApiModelProperty(value = "已占用的最大ID")
    private Integer lastId;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;


}
