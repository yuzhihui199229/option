package com.huayun.option.config.rpc;

import io.netty.channel.Channel;
import org.zeromq.ZMQ;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: yuzh
 * Date: 2021/8/24
 * Description:channel的连接池
 */
public class ChannelPool {

    // 缓存所有的channel key为ip-port
    public static volatile Map<String, Channel> channels = new ConcurrentHashMap<>();

    //缓存所有的ZMQ.Socket
    public static volatile Map<String, ZMQ.Socket> zmqSocket = new ConcurrentHashMap<>();


    public static volatile Set<String> service = new HashSet<>();

    public static volatile Map<String, Set<String>> serviceIps = new ConcurrentHashMap<>();


    public static Channel getChannel(String key) {
        return channels.get(key);
    }

    public synchronized static void addChannel(String key, Channel channel) {
        channels.put(key, channel);
    }

    public synchronized static void addZmqSocket(String key, ZMQ.Socket socket) {
        zmqSocket.put(key, socket);
    }

    public static ZMQ.Socket getZmqSocket(String key) {
        return zmqSocket.get(key);
    }

    public synchronized static void removeChannel(String key) {
        if (channels.containsKey(key)) {
            channels.remove(key);
        }
    }

    public synchronized static void addService(String interfaceName) {
        service.add(interfaceName);
    }


    public synchronized static void addServiceIp(String service, String ipPort) {
        if (serviceIps.containsKey(service)) {
            serviceIps.get(service).add(ipPort);
        } else {
            Set<String> set = new HashSet<>();
            set.add(ipPort);
            serviceIps.put(service, set);
        }

    }
}
