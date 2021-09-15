package com.huayun.option.request;

import com.google.protobuf.Message;
import com.huayun.option.model.MagicNo;
import com.huayun.option.protobuf.Head;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class BaseRequest {
    /**
     * 格式化请求
     * @return
     */
    protected byte[] formatRequest(Head head, Message.Builder body) throws IOException {
        //获取body的字节
        byte[] bodyByteArray = body.build().toByteArray();
        //获取body的长度
        int bodyLen = bodyByteArray.length;
        int totalLen= MagicNo.headLen + bodyLen;
        //将头和前端传入字段传入ByteBuffer中
        ByteBuffer byteBuffer = ByteBuffer.allocate(totalLen);
        //将字节存入缓冲字节流中,设置为小端，Java默认的是大端
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN)
                .putInt(totalLen)
                .putInt(head.getMsgId())
                .putInt(head.getRetCode())
                .put(bodyByteArray);
        return byteBuffer.array();
    };

}
