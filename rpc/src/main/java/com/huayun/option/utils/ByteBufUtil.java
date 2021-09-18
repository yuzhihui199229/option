package com.huayun.option.utils;

import io.netty.buffer.ByteBuf;

import java.nio.charset.StandardCharsets;

/**
 * 工具类byteBuf
 */
public class ByteBufUtil {
    public static void writeCharSequence(ByteBuf byteBuf, String src, int len) {
        byteBuf.writeCharSequence(src, StandardCharsets.UTF_8);
        byteBuf.writeZero(len-src.getBytes(StandardCharsets.UTF_8).length);
    }
}
