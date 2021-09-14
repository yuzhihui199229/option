package com.huayun.option.response;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.List;

public class BaseResponse<T> {
    /**
     * 解析服务返回的应答
     * @return T
     * @throws InvalidProtocolBufferException
     */
    T parseResponse() throws InvalidProtocolBufferException{
        return null;
    };

    /**
     * 解析服务返回的list类型的应答
     * @return
     * @throws InvalidProtocolBufferException
     */
    List<T> parseResponseList() throws InvalidProtocolBufferException{
        return null;
    };
}
