package com.huayun.option.utils;

import com.huayun.option.model.ClientMgrCode;
import com.huayun.option.protobuf.Protocol;
import com.huayun.option.response.Result;
import com.huayun.option.response.RspSelAssetInfo;

import java.util.List;

public class ResultUtil {
    /**
     * 封装result的code和对应的message
     * @param protocol
     * @return
     */
    public static <T> Result getResult(Protocol protocol, List<T> list) {
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
        result.setData(list);
        return result;
    }
}
