package com.huayun.option.service;

import com.huayun.option.annotation.RpcProxy;
import com.huayun.option.model.ParseType;
import com.huayun.option.protobuf.Protocol;

/**
 * ProtoBuf解析方式
 */
@RpcProxy(parseType = ParseType.PROTOBUF)
public interface ProtoBufService {
    /**
     * protobuf转化
     * @param bytes
     * @return
     */
    byte[] parseByprotoBuf(byte[] bytes);

}
