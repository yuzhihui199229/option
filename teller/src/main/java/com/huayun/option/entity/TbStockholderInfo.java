package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 股东账户表
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbStockholderInfo对象", description="股东账户表")
public class TbStockholderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "用户ID")
    private Integer uuserId;

    @ApiModelProperty(value = "资金账户ID")
    private Integer uassetInfoId;

    @ApiModelProperty(value = "合约账户")
    private String accountId;

    @ApiModelProperty(value = "股票股东账户")
    private String stockholderAccount;

    @ApiModelProperty(value = "交易等级;：3级")
    private Integer tradeLimitLevel;

    @ApiModelProperty(value = "持仓等级;：4级")
    private Integer posiLimitLevel;

    @ApiModelProperty(value = "账户状态;0正常，1冻结")
    private Integer accountStatus;

    @ApiModelProperty(value = "注册时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;

    @ApiModelProperty(value = "版本号")
    private Integer vers;


}
