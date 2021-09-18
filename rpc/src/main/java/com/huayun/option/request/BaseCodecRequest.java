package com.huayun.option.request;

import com.huayun.option.codec.ProtocolCodec;

public abstract class BaseCodecRequest {
    /**
     * 格式化请求
     * @return
     */
    abstract ProtocolCodec formatRequest(int uuserId,int sessionId) ;

}
