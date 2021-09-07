package com.huayun.option.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "CombinedStrategyLegsInfo",description = "组合策略多腿信息")
public class CombinedStrategyLegsInfo {

    @ApiModelProperty(value = "成分合约代码",dataType = "char[8]")
    private String legSecurityID;

    @ApiModelProperty(value = "成分合约代码源",dataType = "char[4]")
    private String legSecurityIDSource;

    @ApiModelProperty(value = "成分合约方向:1=权力仓‘2’=义务仓",dataType = "char")
    private String legSide;

    @ApiModelProperty(value = "成份合约数量")
    private Long legOrderQty;
}
