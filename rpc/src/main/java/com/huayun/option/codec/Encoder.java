package com.huayun.option.codec;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;

/**
 * 消息的编码
 */
public class Encoder extends MessageToByteEncoder<ProtocolCodec> {

    @Override
    protected void encode(ChannelHandlerContext ctx, ProtocolCodec protocol, ByteBuf out) throws Exception {
        if (protocol == null || protocol.getHeadCodec() == null) {
            throw new Exception("protocol can not be null.");
        }
        //将要发送的数据解析成包
        HeadCodec head = protocol.getHeadCodec();
        out.writeShortLE(head.getMagicNum());
        out.writeCharSequence(head.getVersion(), StandardCharsets.UTF_8);
        out.writeCharSequence(head.getMsgType(),StandardCharsets.UTF_8);
        out.writeShortLE(head.getSourceId());
        out.writeIntLE(head.getSessionId());
        out.writeShortLE(head.getFuncNo());
        out.writeIntLE(head.getMsgLen());
        out.writeIntLE(head.getMsgSeq());
        out.writeIntLE(head.getRetCode());
        out.writeLongLE(head.getMktCode());
        out.writeBytes(protocol.getBody());
        System.out.println("send request to server : " + out.toString());
//        log.info("send request to server : " + out.toString());
    }
}
