package com.huayun.option.codec;

import com.huayun.option.model.MagicNo;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 消息的解码
 */
public class Decoder extends ByteToMessageDecoder {

    /**
     * 数据的解析
     *
     * @param ctx
     * @param in
     * @param out
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        //如果可读的数小于消息头的长度返回
        if (in.readableBytes() <= MagicNo.headCodecLen)
            return;
        HeadCodec headCodec = new HeadCodec();
        short magicNum = in.readShortLE();
        if (magicNum != MagicNo.magicNum)
            return;
        headCodec.setMagicNum(magicNum)
                .setVersion((String) in.readCharSequence(1, StandardCharsets.UTF_8))
                .setMsgType((String) in.readCharSequence(1,StandardCharsets.UTF_8))
                .setSourceId(in.readShortLE())
                .setSessionId(in.readIntLE())
                .setFuncNo(in.readShortLE())
                .setMsgLen(in.readIntLE())
                .setMsgSeq(in.readIntLE())
                .setRetCode(in.readIntLE())
                .setMktCode(in.readLongLE());
        ByteBuf byteBuf = in.readBytes(headCodec.getMsgLen() - MagicNo.headCodecLen);
        ProtocolCodec protocolCodec = new ProtocolCodec();
        protocolCodec.setHeadCodec(headCodec)
                .setBody(byteBuf);

    }

}
