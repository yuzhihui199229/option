package com.huayun.option.request;

import com.huayun.option.exception.CopyPropertyException;
import com.huayun.option.model.MsgId;
import com.huayun.option.protobuf.ClientMgr;
import com.huayun.option.protobuf.Head;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.IOException;

@Data
@ApiModel(value = "ReqExercise",description = "行权业务请求")
public class ReqExercise extends ReqSelInterface {
//    @ApiModelProperty(value = "用户名",dataType = "char[32]")
//    private String userName;
//
//    @ApiModelProperty(value = "账户")
//    private Integer account;
//
//    @ApiModelProperty(value = "合约账户标识码")
//    private String contractAccCode;
    /**
     * 将请求的参数转化为字节数组
     *
     * @return
     */
    @Override
    public byte[] formatRequest(int retCode) throws IOException {
        //消息头封装
        Head head = new Head();
        head.setMsgId(MsgId.MSG_QUERY_POSITION_RIGHT.getId())
                .setRetCode(retCode);
        //消息体封装
        ClientMgr.ReqSelInterface.Builder body = ClientMgr.ReqSelInterface.newBuilder();
        body.setToken(this.token);
        return formatRequest(head, body);
    }
}
