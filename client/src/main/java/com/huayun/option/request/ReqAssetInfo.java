package com.huayun.option.request;

import com.huayun.option.model.MsgId;
import com.huayun.option.protobuf.ClientMgr;
import com.huayun.option.protobuf.Head;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.IOException;

@Data
@Accessors(chain = true)
@ApiModel(value = "ReqAssetInfo", description = "资金信息")
public class ReqAssetInfo extends ReqSelInterface {

    /**
     * 将请求的参数转化为字节数组
     *
     * @return
     */
    @Override
    public byte[] formatRequest(int retCode) throws IOException {
        //消息头封装
        Head head = new Head();
        head.setMsgId(MsgId.MSG_QUERY_ASSET.getId())
                .setRetCode(retCode);
        //消息体封装
        ClientMgr.ReqSelInterface.Builder body = ClientMgr.ReqSelInterface.newBuilder();
        body.setToken(this.token);
        return formatRequest(head, body);
    }

}
