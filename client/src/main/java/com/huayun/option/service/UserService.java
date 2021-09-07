package com.huayun.option.service;

import com.huayun.option.annotation.RpcProxy;
import com.huayun.option.model.ParseType;
import com.huayun.option.protobuf.Protocol;

/**
 * 用户
 */
@RpcProxy(parseType = ParseType.PROTOBUF)
public interface UserService {
    /**
     * 查询用户信息
     * @param bytes
     * @return
     */
    Protocol userInfo(byte[] bytes);
}
