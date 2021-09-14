package com.huayun.option.request;

import com.google.protobuf.Message;
import com.huayun.option.model.MagicNo;
import com.huayun.option.model.MsgId;
import com.huayun.option.protobuf.ClientMgr;
import com.huayun.option.protobuf.Head;
import com.huayun.option.utils.JsonUtil;
import com.huayun.option.utils.ProtoJsonUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@Data
@Accessors(chain = true)
@ApiModel(value = "ReqAssetInfoAndOptionPosition", description = "资金信息和期权持仓公共请求")
public class ReqAssetInfoAndOptionPosition extends BaseRequest<ReqAssetInfoAndOptionPosition> {

    @ApiModelProperty(value = "token", required = true)
    protected String token;

}
