package com.huayun.option.utils;

import com.huayun.option.codec.HeadCodec;
import com.huayun.option.codec.ProtocolCodec;
import com.huayun.option.model.ClientMgrCode;
import com.huayun.option.protobuf.ClientMgr;
import com.huayun.option.protobuf.Protocol;
import com.huayun.option.response.Result;

public class ResultUtil {
    /**
     * protocol 封装 result 的 code 和对应的 message
     *
     * @param protocol
     * @return
     */
    public static Result getResult(Protocol protocol) {
        Result result = new Result();
        int retCode = protocol.getHead().getRetCode();
        result.setCode(retCode);
        //retCode对应的信息
        for (ClientMgrCode clientMgrCode : ClientMgrCode.values()) {
            if (retCode == clientMgrCode.ordinal()) {
                result.setMessage(clientMgrCode.getMessage());
                break;
            }
        }
        result.setData(protocol.getBody());
        return result;
    }

    /**
     * protocolCodec 封装 result 的 code 和对应的 message
     * @param headCodec
     * @param t
     * @return
     */
    public static <T> Result getResult(HeadCodec headCodec, T t ) {
        Result result = new Result();
        int retCode = headCodec.getRetCode();
        result.setCode(retCode);
        //retCode对应的信息
        for (ClientMgrCode clientMgrCode : ClientMgrCode.values()) {
            if (retCode == clientMgrCode.ordinal()) {
                result.setMessage(clientMgrCode.getMessage());
                break;
            }
        }
        result.setData(t);
        return result;
    }

}
