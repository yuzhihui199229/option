package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 申报单元表
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbPbuid对象", description="申报单元表")
public class TbPbuid implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "申报单元")
    private String pbu;

    @ApiModelProperty(value = "用户PBU流速权;, 0：默认无限制， 其他：每秒下单限速")
    private Integer speedLimit;


}
