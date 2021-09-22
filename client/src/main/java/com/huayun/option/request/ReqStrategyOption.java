package com.huayun.option.request;

import com.huayun.option.exception.CopyPropertyException;
import com.huayun.option.model.MsgId;
import com.huayun.option.protobuf.ClientMgr;
import com.huayun.option.protobuf.Head;
import io.swagger.annotations.ApiModel;

import java.io.IOException;
@ApiModel(value = "ReqStrategyOption", description = "组合策略持仓")
public class ReqStrategyOption extends ReqSelInterface{
    /**
     * 将请求的参数转化为字节数组
     *
     * @return
     */
    @Override
    public byte[] formatRequest(int retCode) throws IOException {
        //消息头封装
        Head head = new Head();
        head.setMsgId(MsgId.MSG_QUERY_STRATEGY.getId())
                .setRetCode(retCode);
        //消息体封装
        ClientMgr.ReqSelInterface.Builder body = ClientMgr.ReqSelInterface.newBuilder();
        body.setToken(this.token);
        return formatRequest(head, body);
    }
}
