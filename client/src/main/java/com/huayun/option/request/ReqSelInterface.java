package com.huayun.option.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "ReqSelInterface", description = "资金信息和期权持仓公共请求")
public class ReqSelInterface extends BaseRequest {

    @ApiModelProperty(value = "token", required = true)
    protected String token;

}
