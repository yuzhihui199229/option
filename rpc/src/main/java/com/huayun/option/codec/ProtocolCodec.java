package com.huayun.option.codec;

import io.netty.buffer.ByteBuf;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProtocolCodec {
    private HeadCodec headCodec;
    private ByteBuf body;
}
