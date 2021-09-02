package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 会话表(MyISAM)
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbSession对象", description="会话表(MyISAM)")
public class TbSession implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "用户ID")
    private Integer uuserId;

    private String token;

    @ApiModelProperty(value = "客户端类型")
    private Integer clientType;

    @ApiModelProperty(value = "状态")
    private Integer sessionStatus;

    @ApiModelProperty(value = "套接字;，仅内部使用")
    private Integer socket;

    @ApiModelProperty(value = "服务索引;，服务重启后，会生成新的server_id")
    private Integer serverId;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;


}
