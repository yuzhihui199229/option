package com.huayun.option.zmq;

import com.huayun.option.model.MagicNo;
import com.huayun.option.protobuf.Head;
import com.huayun.option.protobuf.Protocol;
import io.netty.handler.ssl.ApplicationProtocolConfig;
import lombok.extern.slf4j.Slf4j;
import org.zeromq.SocketType;
import org.zeromq.ZMQ;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * zmq客户端
 */
public class ZmqClient {

    /**
     * zmq发送消息
     * @param bytes
     * @return
     * @throws Exception
     */
    public static byte[] sendMessage(byte[] bytes, ZMQ.Socket socket) throws Exception {
        socket.send(bytes);
        return socket.recv();
    }

    /**
     * zmq建立连接
     * @param ip
     * @param port
     */
    public static ZMQ.Socket createConnect(String ip, int port) {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(SocketType.REQ);
        String url = "tcp://" + ip + ":" + port;
        //连接服务端
        boolean connect = socket.connect(url);
        if (connect) {
            System.out.println("============================zmq 连接=============================");
//            log.info("============================zmq 连接=============================");
        } else {
//            log.info("==========================zmq 连接失败============================");
            System.out.println("==========================zmq 连接失败============================");
        }
        return socket;
    }
}
