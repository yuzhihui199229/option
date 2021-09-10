package com.huayun.option.netty;

import com.huayun.option.codec.ProtocolCodec;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class NettyRequestPool {

    private static volatile NettyRequestPool NettyRequestPool = null;

    private NettyRequestPool() {

    }

    /**
     * 获取nettyPool的实力对象，单实例
     * @return
     */
    public static NettyRequestPool getInstance() {
        if (NettyRequestPool == null) {
            synchronized (NettyRequestPool.class) {
                if (NettyRequestPool == null) {
                    NettyRequestPool = new NettyRequestPool();
                }
            }
        }
        return NettyRequestPool;
    }

    private static final Map<Integer, Promise<ProtocolCodec>> requestPool = new ConcurrentHashMap<>();

    /**
     * 添加请求的request
     */
    public void addRequest(Integer requestId, EventExecutor executor){
        requestPool.put(requestId, new DefaultPromise<ProtocolCodec>(executor));
    }

    /**
     * 获取到应答
     * @param requestId
     * @return
     * @throws Exception
     */
    public ProtocolCodec getResponse(Integer requestId) throws Exception {
        //获取远程调用结果 10s超时
        Promise<ProtocolCodec> promise = requestPool.get(requestId);
        //no service provided
        if (promise == null){
            return null;
        }
        ProtocolCodec protocol = promise.get(10, TimeUnit.SECONDS);
        requestPool.remove(requestId);
        return protocol;
    }

    /**
     * 唤醒请求
     * @param requestId
     * @param protocol
     */
    public void notifyRequest(Short requestId, ProtocolCodec protocol){
        Promise<ProtocolCodec> promise = requestPool.get(requestId);
        if (promise != null){
            promise.setSuccess(protocol);
        }
    }
}
