package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 管理员表(MyISAM)
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbTellInfo对象", description="管理员表(MyISAM)")
public class TbTellInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "管理员ID")
    private String userId;

    @ApiModelProperty(value = "管理员名字")
    private String userName;

    @ApiModelProperty(value = "登录密码")
    private String password;

    @ApiModelProperty(value = "类型")
    private Integer clientType;

    @ApiModelProperty(value = "管理员状态")
    private Integer userStatus;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;

}
