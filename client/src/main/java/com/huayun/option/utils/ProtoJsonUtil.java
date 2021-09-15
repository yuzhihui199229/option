package com.huayun.option.utils;

import com.google.gson.Gson;
import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;

import java.io.IOException;

/**
 * 特别主要：
 * <ul>
 *  <li>该实现无法处理含有Any类型字段的Message</li>
 *  <li>enum类型数据会转化为enum的字符串名</li>
 *  <li>bytes会转化为utf8编码的字符串</li>
 * </ul>
 */
public class ProtoJsonUtil {

    public static String toJson(Message sourceMessage)
            throws IOException {
        return JsonFormat.printer().print(sourceMessage);
    }

    public static Message toProtoBean(Message.Builder targetBuilder, String json) throws IOException {
        JsonFormat.parser().merge(json, targetBuilder);
        return targetBuilder.build();
    }
}