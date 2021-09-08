package com.huayun.option.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "RspCoveredTurned",description = "备兑开平仓与互转应答")
public class RspCoveredTurned {

    @ApiModelProperty(value = "客户订单编号对应整型ID")
    private Integer id;

    @ApiModelProperty(value = "客户订单编号",dataType = "char[10]")
    private String  clOrdID;

    @ApiModelProperty(value = "订单状态")
    private String ordStatus;

    @ApiModelProperty(value = "版本信息，保留")
    private Integer version;
}
