package com.huayun.option.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "RspOrderCancel",description = "撤单响应")
public class RspOrderCancel {
    @ApiModelProperty(value = "客户订单编号")
    private String ClOrdID;

    @ApiModelProperty(value = "版本号")
    private Integer version;
}
