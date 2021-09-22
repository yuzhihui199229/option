package com.huayun.option.response;

import com.google.protobuf.InvalidProtocolBufferException;
import com.huayun.option.codec.ProtocolCodec;
import com.huayun.option.model.MagicNo;
import com.huayun.option.protobuf.Head;
import com.huayun.option.protobuf.Protocol;
import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class BaseCodecResponse<T> {
    /**
     * 解析服务返回的应答
     *
     * @return T
     */
    abstract T parseResponse(ByteBuf byteBuf);
}
