package com.huayun.option.config.rpc;

import com.huayun.option.annotation.RpcProxy;
import com.huayun.option.codec.HeadCodec;
import com.huayun.option.codec.ProtocolCodec;
import com.huayun.option.model.FuncNo;
import com.huayun.option.model.ParseType;
import com.huayun.option.netty.NettyClient;
import com.huayun.option.netty.NettyRequestPool;
import com.huayun.option.protobuf.Protocol;
import com.huayun.option.zmq.ZmqClient;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.zeromq.ZMQ;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 通过代理的方法，选择不同的解析类
 */
@Component
public class RPCInvocationHandler implements InvocationHandler {

    public RPCInvocationHandler() {
    }

    private Class<?> type;

    public RPCInvocationHandler(Class<?> type){
        this.type = type;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //获取类名信息
        String className = type.getName();
        //获取service上的注解信息
        ParseType parseType = type.getAnnotation(RpcProxy.class).parseType();
        //如果注解上的解析的类型是protobuf，就用protobuf解析，否则就用codec解析
        if (parseType.name().equals(ParseType.PROTOBUF.name())) {
            byte[] bytes = (byte[]) args[0];
            //获取到该接口所对应的zmqSocket对象
            ZMQ.Socket zmqSocket = ChannelPool.getZmqSocket(className + "-" + parseType.name());
            //zmq向服务端发送消息
            return ZmqClient.sendMessage(bytes, zmqSocket);
        } else {
            //获取的到参数
            ProtocolCodec protocolCodec=(ProtocolCodec)args[0];
            HeadCodec headCodec = protocolCodec.getHeadCodec();
            int sessionId = headCodec.getSessionId();
//            //获取到注解中的功能号
//            FuncNo funcNo = type.getAnnotation(RpcProxy.class).funcNo();
//            Short funcNoCode = funcNo.getCode();
            //获取到该接口所对应的channel对象
            Channel channel = ChannelPool.getChannel(className + "-" + parseType.name());
            //netty向服务端发送消息
            NettyClient.send(protocolCodec,channel);
            //将服务的channel保存到channel中
            NettyRequestPool.getInstance().addRequest(sessionId, channel.eventLoop());
            //获取到应答
            ProtocolCodec response = NettyRequestPool.getInstance().getResponse(sessionId);
            return response;
        }
    }
}
