package com.huayun.option.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "RspCombinedStrategySuccess",description = "组合策略构建申成功应答")
public class RspCombinedStrategySuccess {

    @ApiModelProperty(value = "交易所订单编号",dataType = "char[16]")
    private String orderID;

    @ApiModelProperty(value = "客户订单编号",dataType = "char[10]")
    private String clOrdID;

    @ApiModelProperty(value = "订单状态",dataType = "char")
    private String ordStatus;
}
