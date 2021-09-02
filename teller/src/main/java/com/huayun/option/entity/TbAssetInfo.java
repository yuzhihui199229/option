package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 资金信息表(MyISAM)
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbAssetInfo对象", description="资金信息表(MyISAM)")
public class TbAssetInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "保证金账户")
    private String assetAccount;

    @ApiModelProperty(value = "合约账户ID")
    private Integer uuserId;

    @ApiModelProperty(value = "日间余额")
    private Double balance;

    @ApiModelProperty(value = "冻结资金")
    private Double frozen;

    @ApiModelProperty(value = "实时保证金")
    private Double marginAmount;

    @ApiModelProperty(value = "注册时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;

    @ApiModelProperty(value = "资金版本号")
    private Integer vers;


}
