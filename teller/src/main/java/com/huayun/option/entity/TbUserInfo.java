package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbUserInfo对象", description="用户信息表")
public class TbUserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增用户ID;用户[1]->合约账户[N]")
    private Integer id;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "开户公司ID")
    private String companyId;

    @ApiModelProperty(value = "证券公司开户账号")
    private String userAccount;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "用户属性")
    private Integer userPropty;

    @ApiModelProperty(value = "用户状态;, 0正常，1冻结，2禁止")
    private Integer userStatus;

    @ApiModelProperty(value = "用户费率组")
    private Integer feeGroup;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;


}
