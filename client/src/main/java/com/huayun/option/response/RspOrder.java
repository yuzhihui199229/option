package com.huayun.option.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "RspOrder",description = "订单响应")
public class RspOrder {
    @ApiModelProperty(value = "客户订单编号",dataType = "char[10]")
    private String clOrdID;

    @ApiModelProperty(value = "版本号")
    private Integer version;
}
