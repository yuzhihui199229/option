package com.huayun.option.model;

/**
 * 消息id类，每个消息id对应固定的请求方法
 */
public enum MsgId {
    /**
     * 登录
     */
    MSG_LOGIN(201),

    /**
     * 查询资金
     */
    MSG_QUERY_ASSET(217),

    /**
     * 查询资金流水
     */
    MSG_QUERY_ASSET_LOG(218),

    /**
     * 期权持仓查询
     */
    MSG_QUERY_POSITION (232),

    MSG_QUERY_USER_INFO(211);   //查询用户信息

    private int Id;

    MsgId(int msgId) {
        this.Id = msgId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }
}
