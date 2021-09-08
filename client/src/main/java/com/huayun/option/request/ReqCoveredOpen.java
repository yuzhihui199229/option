package com.huayun.option.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ReqCoveredOpen",description = "备兑开仓")
public class ReqCoveredOpen {
    @ApiModelProperty(value = "令牌",dataType = "char[32]",required = true)
    private String token;

    @ApiModelProperty(value = "新订单公共部分",dataType = "NewOrder")
    private NewOrder newOrder;

    @ApiModelProperty(value = "止损价",required = true)
    private Long stopPx;

    @ApiModelProperty(value = "最低成交数量",required = true)
    private Long minQty;

    @ApiModelProperty(value = "最多成交位数",required = true)
    private Short maxPriceLevels;

    @ApiModelProperty(value = "订单有效时间类型",dataType = "char",required = true)
    private String timeInForce;

    @ApiModelProperty(value = "平仓标识:O:开仓，C:平仓",dataType = "char",required = true)
    private String positionEffect;

    @ApiModelProperty(value = "备兑标签:0:备兑，1:非备兑",required = true)
    private Byte coveredFlag;

    @ApiModelProperty(value = "合约账户标识码",dataType = "char[6]",required = true)
    private String conTractAcctCode;

    @ApiModelProperty(value = "校验和",required = true)
    private Integer checkSum;

    @ApiModelProperty(value = "交易单元ID",required = true)
    private Short pbuID;

    @ApiModelProperty(value = "合约账户ID",required = true)
    private Integer accID;

    @ApiModelProperty(value = "期权账户ID",required = true)
    private Integer optionID;

    @ApiModelProperty(value = "期权持仓ID",required = true)
    private Integer posID;

}
