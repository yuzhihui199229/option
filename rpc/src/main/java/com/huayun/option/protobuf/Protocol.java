package com.huayun.option.protobuf;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Protocol {
    /**
     * 请求头
     */
    private Head head;

    /**
     * 请求体
     */
    private byte[] body;
}
