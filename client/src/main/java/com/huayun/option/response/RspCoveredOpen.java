package com.huayun.option.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RspCoveredOpen",description = "备兑开仓应答")
public class RspCoveredOpen {

    @ApiModelProperty(value = "客户订单编号对应整型ID")
    private Integer id;

    @ApiModelProperty(value = "客户订单编号")
    private String clOrdID;

    @ApiModelProperty(value = "订单状态",dataType = "char")
    private String ordStatus;

    @ApiModelProperty(value = "版本信息，保留")
    private Integer version;
}
