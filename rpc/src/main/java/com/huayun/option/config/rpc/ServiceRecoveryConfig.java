package com.huayun.option.config.rpc;

import com.huayun.option.model.ParseType;
import com.huayun.option.netty.NettyClient;
import com.huayun.option.zmq.ZmqClient;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.zeromq.ZMQ;

/**
 * Author: yuzh
 * Date: 2021/8/24
 * Description:服务连接
 */
@Component
public class ServiceRecoveryConfig implements ApplicationListener<ContextRefreshedEvent> {

    @Value("${netty.ip}")
    private String ip;

    @Value("${netty.port}")
    private int port;

    @Value("${zmq.ip}")
    private String zmqIp;

    @Value("${zmq.port}")
    private int zmqPort;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        discoverService();
    }
    //每一个接口与服务分别建立一次连接
    public void discoverService() {
        for (String service : ChannelPool.service) {
            if (service.endsWith(ParseType.CODEC.name())) {
                //如果服务是以socket结尾就创建socket连接
                Channel channel = NettyClient.createChannel(ip, port);
                String ipPorts = ip + ":" + port;
                //保存每个服务对应的channel
                ChannelPool.addChannel(ipPorts, channel);
                //保存每个服务对应的ip和port
                ChannelPool.addServiceIp(service, ipPorts);
            } else if (service.endsWith(ParseType.PROTOBUF.name())) {
                //创建zmq的socket连接
                ZMQ.Socket socket = ZmqClient.createConnect(zmqIp, zmqPort);
                String ipPorts = zmqIp + ":" + zmqPort;
                //保存每个服务对应的socket
                ChannelPool.addZmqSocket(service,socket);
                //保存每个服务对应的ip和port
                ChannelPool.addServiceIp(service, ipPorts);
            }
        }
    }
}
