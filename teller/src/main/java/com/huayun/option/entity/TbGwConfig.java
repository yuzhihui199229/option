package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 交易网关配置表
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbGwConfig对象", description="交易网关配置表")
public class TbGwConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "网关地址;ip:port，与tb_user_pbu_config一致")
    private String gwAddr;

    @ApiModelProperty(value = "发送方ID")
    private String sendCompId;

    @ApiModelProperty(value = "接受方ID")
    private String recvCompId;

    @ApiModelProperty(value = "网关密码")
    private String password;

    @ApiModelProperty(value = "连接状态")
    private Integer connStatus;

    @ApiModelProperty(value = "登录状态")
    private Integer loginStatus;

    @ApiModelProperty(value = "表记录状态")
    private Integer gwStatus;

    @ApiModelProperty(value = "版本信息")
    private Integer vers;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;


}
