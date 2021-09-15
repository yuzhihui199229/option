package com.huayun.option.model;

/**
 * 消息id类，每个消息id对应固定的请求方法
 */
public enum MsgId {
//    /**
//     * 登录
//     */
//    MSG_LOGIN(201),
//
//    /**
//     * 查询资金
//     */
//    MSG_QUERY_ASSET(217),
//
//    /**
//     * 查询资金流水
//     */
//    MSG_QUERY_ASSET_LOG(218),
//
//    /**
//     * 期权持仓查询
//     */
//    MSG_QUERY_POSITION (232),
//
//    /**
//     * 查询组合策略
//     */
//    MSG_QUERY_STRATEGY(234),
//
//    /**
//     * 期权持仓行权查询
//     */
//    MSG_QUERY_POSITION_RIGHT(236),
//
//    MSG_QUERY_USER_INFO(211);   //查询用户信息

    //主席柜台消息，使用 zmq,protobuf: 1-200
    MSG_LOCK_UNDERLY ( 111),      // 锁定标的资产  -- jianglipeng --
    // MSG_UNLOCK_UNDERLY ( 112),    // 解锁标的资产
    MSG_ASSET_TRANSFER ( 113),    // 资金划转
    MSG_POSITION_TRANSFER ( 114), // 持仓划转、     --  end
    MSG_QUERY_INFO ( 121), // 主席柜台查询

    //客户端管理/查询消息，使用 zmq),protobuf: 201-400
    MSG_LOGIN ( 201),     //用户登录
    MSG_LOGOUT ( 202),    //用户登出
    MSG_HEARTBEAT ( 203), //心跳

    MSG_QUERY_USER_INFO ( 211),     // 查询用户信息
    MSG_QUERY_USER_CONFIG ( 212),   // 查询用户配置
    MSG_QUERY_ACCOUNT ( 213),       // 股东账户查询
    MSG_QUERY_ORDER ( 214),         // 查询订单
    MSG_QUERY_TRADE ( 216),         // 查询成交
    MSG_QUERY_ASSET ( 217),         // 查询资金
    MSG_QUERY_ASSET_LOG ( 218),     // 查询资金流水
    MSG_QUERY_PROFIT_LOSS ( 219),   // 盈亏查询
    MSG_QUERY_STOCK_INFO ( 220),    // 查询股票信息
    MSG_QUERY_TRADE_TIME ( 221),    // 交易时间查询
    MSG_QUERY_FEE_RATE ( 222),      // 费率查询
    MSG_QUERY_PRODUCT_CONFIG ( 231),// 产品配置查询

    MSG_QUERY_POSITION ( 232),      // 期权持仓查询
    MSG_QUERY_CONTRACT_POS ( 233),  // 合约品种持仓查询
    MSG_QUERY_STRATEGY ( 234),      // 查询组合策略
    MSG_QUERY_POSITION_COVER ( 235),// 期权持仓备兑查询
    MSG_QUERY_POSITION_RIGHT ( 236),// 期权持仓行权查询
    MSG_QUERY_STRATEGY_LOG ( 237),  // 查询组合策略流水
    MSG_QUERY_POSITION_LOG ( 238),  // 查询期权持仓流水

    MSG_SET_USER_CONFIG ( 241),     // 修改用户配置
    MSG_SET_POSI_LIMIT ( 242),      // 设置(合约品种)持仓限额
    MSG_QUERY_SECURITY_INFO ( 243), // 证券信息表查询
    MSG_QUERY_GW_CONFIG_INFO ( 244),// 交易网关配置表查询
    MSG_QUERY_USER_PBU_INFO ( 245), // 用户PBU网关配置表查询
    MSG_QUERY_OPTION_INFO ( 246),   // 期权信息查询
    MSG_QUERY_EXEC_REPORT ( 247),   // 交易网关配置表查询
    MSG_CLIENT_DATA_SYNC ( 251);    // 客户端数据同步


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
