package com.huayun.option.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Result对象", description="返回结果")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Result {
    @ApiModelProperty(value = "返回码")
    private Integer retCode;

    @ApiModelProperty(value = "返回信息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Object data;

    public Result(Integer retCode, String message) {
        this.retCode = retCode;
        this.message = message;
    }
}
