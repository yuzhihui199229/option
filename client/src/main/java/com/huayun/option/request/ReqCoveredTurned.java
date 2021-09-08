package com.huayun.option.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ReqCoveredTurned",description = "备兑开平仓与互转请求")
public class ReqCoveredTurned {

    @ApiModelProperty(value = "token",dataType = "char[32]",required = true)
    private String token;

    @ApiModelProperty(value = "新订单公共部分",dataType = "NewOrder",required = true)
    private NewOrder newOrder;

    @ApiModelProperty(value = "合约账户标识码",dataType = "char[6]",required = true)
    private String conTractAcctCode;

    @ApiModelProperty(value = "校验和",required = true)
    private Integer checkSum;

    @ApiModelProperty(value = "交易单元ID",required = true)
    private Short pbuID;

    @ApiModelProperty(value = "合约账户ID",required = true)
    private Integer accID;

    @ApiModelProperty(value = "资金账户ID")
    private Integer assetID;

    @ApiModelProperty(value = "期权账户ID",required = true)
    private Integer optionID;

    @ApiModelProperty(value = "期权持仓ID",required = true)
    private Integer posID;

}
