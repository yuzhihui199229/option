package com.huayun.option.service;

import com.huayun.option.annotation.RpcProxy;
import com.huayun.option.model.ParseType;
import com.huayun.option.protobuf.Protocol;

/**
 * 用户
 */
@RpcProxy(parseType = ParseType.PROTOBUF)
public interface ProtoBufService {
    /**
     * protobuf转化
     * @param bytes
     * @return
     */
    Protocol protoBufTurn(byte[] bytes);

}