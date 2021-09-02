package com.huayun.option.protobuf;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Head {
    /**
     * 总长度
     */
    int totalLen;

    /**
     * 消息id,对应要调用的方法的msgId
     */
    int msgId;

    /**
     * 返回码
     */
    int retCode;
}