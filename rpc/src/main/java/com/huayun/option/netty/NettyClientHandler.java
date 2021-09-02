package com.huayun.option.netty;

import com.huayun.option.codec.HeadCodec;
import com.huayun.option.codec.ProtocolCodec;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.stereotype.Component;

/**
 * Author: yuzh
 * Date: 2021/8/24
 * Description:
 */
@Component
@ChannelHandler.Sharable
public class NettyClientHandler extends SimpleChannelInboundHandler<ProtocolCodec> {
    Object result;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("NettyClientHandler......channelActive............");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("NettyClientHandler......channelInactive............");
    }

    @Override
    protected synchronized void channelRead0(ChannelHandlerContext channelHandlerContext, ProtocolCodec protocol) throws Exception {
        System.out.println("NettyClientHandler...channelRead0...");
        if (protocol != null) {
            HeadCodec headCodec = protocol.getHeadCodec();
            short funcNo = headCodec.getFuncNo();
            NettyRequestPool.getInstance().notifyRequest(funcNo, protocol);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }
}
