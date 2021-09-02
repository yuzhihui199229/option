package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户配置表
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbUserConfig对象", description="用户配置表")
public class TbUserConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "和用户表一致")
    private Integer id;

    @ApiModelProperty(value = "合约账户ID")
    private Integer uaccountId;

    @ApiModelProperty(value = "PBU索引ID;internal use")
    private Integer upbuId;

    @ApiModelProperty(value = "申报交易单元")
    private String submitPbuId;

    @ApiModelProperty(value = "订单所有者类型")
    private Integer ownerType;

    @ApiModelProperty(value = "结算机构代码")
    private String clearingFirm;

    @ApiModelProperty(value = "营业部代码")
    private String branchId;

    @ApiModelProperty(value = "订单限定")
    private String orderRestrict;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;

    @ApiModelProperty(value = "版本号")
    private Integer vers;


}
