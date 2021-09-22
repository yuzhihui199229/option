package com.huayun.option.service;

import com.huayun.option.annotation.RpcProxy;
import com.huayun.option.model.ParseType;
import com.huayun.option.protobuf.Protocol;

/**
 * ProtoBuf解析方式
 */
@RpcProxy(parseType = ParseType.PROTOBUF,name="protoBuf")
public interface ProtoBufService {
    /**
     * protobuf转化
     * @param bytes 请求的字节数
     * @return byte[] 返回的字节数
     */
    byte[] parseByprotoBuf(byte[] bytes);

}
