package com.huayun.option.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ReqExercise",description = "行权业务请求")
public class ReqExercise {
    @ApiModelProperty(value = "用户名",dataType = "char[32]")
    private String userName;

    @ApiModelProperty(value = "账户")
    private Integer account;

    @ApiModelProperty(value = "合约账户标识码")
    private String contractAccCode;
}
