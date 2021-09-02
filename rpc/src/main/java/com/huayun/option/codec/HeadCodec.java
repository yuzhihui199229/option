package com.huayun.option.codec;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString
public class HeadCodec {
    /**
     * 消息头魔数
     */
    private short magicNum;

    /**
     * 版本号:0x01, odd is reserved for hardware
     */
    private String version;

    /**
     * 包类型:0x0未知,0x1请求消息,0x2响应消息,0x3通知消息,0x4:确认消息,0x5透传消息,0x6配置消息
     */
    private String msgType;

    /**
     * 发送方的服务ID，0x1000:Host；0x1001:FPGA客户端接入模块
     */
    private short sourceId;

    /**
     * 序号，登录接口返回，后面其他接口传递，用于获取token,4字节
     */
    private int sessionId;

    /**
     * 功能号
     */
    private short funcNo;

    /**
     * 报文的总长度,4字节,含头部
     */
    private int msgLen;

    /**
     * 消息ID，每类发送者的消息ID应唯一,4字节
     */
    private int msgSeq;

    /**
     * 返回码
     */
    private int retCode;

    /**
     * 市场代码
     */
    private long mktCode;

}
