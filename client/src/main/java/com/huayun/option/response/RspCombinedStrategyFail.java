package com.huayun.option.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "RspCombinedStrategyFail",description = "组合策略构建申失败应答")
public class RspCombinedStrategyFail {
    @ApiModelProperty(value = "客户订单编号",dataType = "char[10]")
    private String clOrdID;
}
