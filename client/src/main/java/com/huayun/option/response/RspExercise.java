package com.huayun.option.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RspExercise",description = "行权响应")
public class RspExercise {
    @ApiModelProperty(value = "返回码")
    private Integer retCode;
}
