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

//    public static void main(String[] args) {
//        createConnect("localhost", 9999);
//        socket.send("getSingle");
//        byte[] recv = socket.recv();
//        System.out.println("客户端接收的是: [" + new String(recv) + "]");
//    }

//    private static ZMQ.Socket socket;
//
//    /**
//     * zmq发送消息
//     * @param bytes
//     * @return
//     * @throws Exception
//     */
//    public static Protocol sendMessage(byte[] bytes) throws Exception {
//        socket.send(bytes);
//        byte[] receive = socket.recv();
//        ByteBuffer receiveBuffer = ByteBuffer.wrap(receive);
//        //复制headLen到headBuffer中
//        ByteBuffer headBuffer = receiveBuffer.get(new byte[MagicNo.headLen], 0, MagicNo.headLen);
//        //获取应答头
//        Head head = parseHead(headBuffer);
//        //复制headLen之后的字节到body数组
//        int bodyLen = receive.length - MagicNo.headLen;
//        byte[] body = new byte[bodyLen];
//        if (receive.length > MagicNo.headLen)
//            System.arraycopy(receive, MagicNo.headLen,body,0,bodyLen);
//        Protocol protocol = new Protocol();
//        protocol.setHead(head)
//                .setBody(body);
//        return protocol;
//    }

    /**
     * zmq发送消息
     * @param bytes
     * @return
     * @throws Exception
     */
    public static Protocol sendMessage(byte[] bytes, ZMQ.Socket socket) throws Exception {
        socket.send(bytes);
        byte[] receive = socket.recv();
        ByteBuffer receiveBuffer = ByteBuffer.wrap(receive);
        //复制headLen到headBuffer中
        ByteBuffer headBuffer = receiveBuffer.get(new byte[MagicNo.headLen], 0, MagicNo.headLen);
        //获取应答头
        Head head = parseHead(headBuffer);
        //复制headLen之后的字节到body数组
        int bodyLen = receive.length - MagicNo.headLen;
        byte[] body = new byte[bodyLen];
        if (receive.length > MagicNo.headLen)
            System.arraycopy(receive, MagicNo.headLen,body,0,bodyLen);
        Protocol protocol = new Protocol();
        protocol.setHead(head)
                .setBody(body);
        return protocol;
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

    /**
     * 解析返回的消息头
     * @param buffer
     * @return
     */
    private static Head parseHead(ByteBuffer buffer) {
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        //使用bytebuffer来对数据进行处理
        int totalLen = buffer.getInt(0);
        int msgId = buffer.getInt(4);
        int retCode = buffer.getInt(8);
        Head head = new Head();
        //消息头封装
        head.setTotalLen(totalLen)
                .setMsgId(msgId)
                .setRetCode(retCode);
        return head;
    }

}
