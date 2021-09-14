package com.huayun.option.request;

import com.huayun.option.exception.CopyPropertyException;
import com.huayun.option.model.MsgId;
import com.huayun.option.protobuf.ClientMgr;
import com.huayun.option.protobuf.Head;
import com.huayun.option.utils.EntityProtoUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value = "ReqAssetInfo", description = "资金信息")
public class ReqAssetInfo extends ReqAssetInfoAndOptionPosition {

    /**
     * 将请求的参数转化为字节数组
     *
     * @return
     */
    public byte[] formatRequest(int retCode) throws IOException, CopyPropertyException {
        //消息头封装
        Head head = new Head();
        head.setMsgId(MsgId.MSG_QUERY_ASSET.getId())
                .setRetCode(retCode);
        //消息体封装
        ClientMgr.ReqSelInterface.Builder body = ClientMgr.ReqSelInterface.newBuilder();
        body.setToken(this.token);
        return formatBaseRequest(head, body);
    }

}
