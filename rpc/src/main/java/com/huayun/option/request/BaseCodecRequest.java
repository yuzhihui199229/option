package com.huayun.option.request;

import com.google.protobuf.Message;
import com.huayun.option.codec.ProtocolCodec;
import com.huayun.option.model.MagicNo;
import com.huayun.option.protobuf.Head;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class BaseCodecRequest {
    /**
     * 格式化请求
     * @return
     */
    abstract ProtocolCodec formatRequest() throws IOException;

}
