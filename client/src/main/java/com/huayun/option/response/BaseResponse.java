package com.huayun.option.response;

import com.google.protobuf.InvalidProtocolBufferException;

public interface BaseResponse {
    byte[] parseResponse() throws InvalidProtocolBufferException;
}
