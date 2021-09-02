package com.huayun.option.service;

import com.huayun.option.annotation.RpcProxy;
import com.huayun.option.model.ParseType;
import com.huayun.option.protobuf.Protocol;

@RpcProxy(parseType = ParseType.PROTOBUF)
public interface UserService {
    Protocol userInfo(byte[] bytes);
}
