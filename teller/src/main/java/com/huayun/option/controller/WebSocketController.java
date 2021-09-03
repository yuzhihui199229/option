package com.huayun.option.controller;

import com.huayun.option.utils.WebSocketUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * WebSocket前端控制器
 */
@RestController
@RequestMapping("/api/ws")
public class WebSocketController {
    /**
     * 群发消息内容
     *
     * @param message
     * @return
     */
    @RequestMapping(value = "/sendAll", method = RequestMethod.GET)
    public String sendAllMessage(@RequestParam(required = true) String message) {
        try {
            WebSocketUtil.BroadCastInfo(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    /**
     * 指定会话ID发消息
     *
     * @param message 消息内容
     * @param id      连接会话ID
     * @return
     */
    @RequestMapping(value = "/sendOne", method = RequestMethod.GET)
    public String sendOneMessage(@RequestParam(required = true) String message, @RequestParam(required = true) String id) {
        try {
            WebSocketUtil.SendMessage(message, id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}