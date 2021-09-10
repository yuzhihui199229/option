package com.huayun.option.model;

/**
 * 固定的魔法数字类
 */
public class MagicNo {
    /**
     * protobuf请求头的长度
     */
    public static final int headLen = 12;

    /**
     * codec请求头的长度
     */
    public static final int headCodecLen = 32;

    /**
     * 消息头魔数
     */
    public static final short magicNum = (short) 0xDADA;

    /**
     * 系统错误
     */
    public static final int SYSTEM_ERROR = 2001;
}
