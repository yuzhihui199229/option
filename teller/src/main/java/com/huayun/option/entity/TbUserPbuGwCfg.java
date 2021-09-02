package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户PBU网关配置表
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbUserPbuGwCfg对象", description="用户PBU网关配置表")
public class TbUserPbuGwCfg implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "用户ID")
    private Integer uuserId;

    @ApiModelProperty(value = "申报单元ID")
    private Integer upbuId;

    @ApiModelProperty(value = "市场编码;0SZ, 1SH")
    private Integer marketCode;

    @ApiModelProperty(value = "状态;0:nomal 1:deleted")
    private Integer gwStatus;

    @ApiModelProperty(value = "交易网关")
    private String gwAddr;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;


}
