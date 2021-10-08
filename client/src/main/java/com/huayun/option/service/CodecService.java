package com.huayun.option.service;

import com.huayun.option.annotation.RpcProxy;
import com.huayun.option.codec.ProtocolCodec;
import com.huayun.option.model.ParseType;
import io.netty.buffer.ByteBuf;

/**
 * CODEC解析方式
 */
//@RpcProxy(parseType = ParseType.CODEC,name="codec")
public interface CodecService {
    /**
     * CODEC转化
     * @param protocolCodec
     * @return
     */
    ProtocolCodec parseByCodec(ProtocolCodec protocolCodec);
}
