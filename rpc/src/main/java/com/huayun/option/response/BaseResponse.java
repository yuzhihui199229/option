package com.huayun.option.response;

import com.google.protobuf.InvalidProtocolBufferException;
import com.huayun.option.model.MagicNo;
import com.huayun.option.protobuf.Head;
import com.huayun.option.protobuf.Protocol;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class BaseResponse {
    /**
     * 解析服务返回的应答
     * @return T
     * @throws InvalidProtocolBufferException
     */
    Protocol parseResponse(byte[] rspBytes) throws IOException {
        ByteBuffer receiveBuffer = ByteBuffer.wrap(rspBytes);
        //复制headLen到headBuffer中
        ByteBuffer headBuffer = receiveBuffer.get(new byte[MagicNo.headLen], 0, MagicNo.headLen);
        //获取应答头
        Head head = parseHead(headBuffer);
        //复制headLen之后的字节到body数组
        int bodyLen = rspBytes.length - MagicNo.headLen;
        byte[] body = new byte[bodyLen];
        if (rspBytes.length > MagicNo.headLen)
            System.arraycopy(rspBytes, MagicNo.headLen,body,0,bodyLen);
        Protocol protocol = new Protocol();
        protocol.setHead(head)
                .setBody(body);
        return protocol;
    };

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
