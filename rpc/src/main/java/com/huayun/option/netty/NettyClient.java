package com.huayun.option.netty;

import com.huayun.option.codec.Decoder;
import com.huayun.option.codec.Encoder;
import com.huayun.option.codec.ProtocolCodec;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.stereotype.Component;

/**
 * Author: yuzh
 * Date: 2021/8/24
 * Description:
 */
@Component
public class NettyClient {
//    private static Channel channel;

//    public static void send(Protocol protocol) {
//        channel.writeAndFlush(protocol);
//    }

    public static void send(ProtocolCodec protocol, Channel channel) {
        channel.writeAndFlush(protocol);
    }

    public static Channel createChannel(String ip, int port) {
        System.out.println("============================================================");
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        bootstrap.group(nioEventLoopGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY,true)
                .remoteAddress(ip, port)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new Encoder());
                        pipeline.addLast(new Decoder());
                        pipeline.addLast(new NettyClientHandler());
                    }
                });
        try {
            Channel channel = bootstrap.connect().sync().channel();
            return channel;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
