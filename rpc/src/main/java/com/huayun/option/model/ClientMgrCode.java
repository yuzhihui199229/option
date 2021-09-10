package com.huayun.option.model;

/**
 * 发送码，返回码
 */
public enum ClientMgrCode {
    RET_OK("ok"),
    RET_NO_HANDLER("没该消息处理函数"),
    RET_ERROR_FLAG("错误开/平、买/卖、备兑标识"),
    RET_NO_USER("用户不存在"),
    RET_USER_STATUS("用户状态异常"),
    RET_NO_ACCOUNT("股东账户不在在"),
    RET_ACCOUNT_STATUS("股东账户状态异常"),
    RET_PASSWD_ERROR("密码错误"),
    RET_NO_OPTION("期权ID不存在"),
    RET_OPTION_STATUS("期权状态异常"),
    RET_NO_OPTION_POS("期权持仓不存在"),
    RET_NO_SECURITY("标的物ID不存在"),
    RET_NO_ASSET("资金账户不存在"),
    RET_NO_CONTRACT_POS("合约标的持仓不存在"),
    RET_NO_POS_LIMIT("没有持仓限额配置"),
    RET_MORE_POS_LIMIT("超持仓限额"),
    RET_TIME_ILLEGAL("超出交易市价范围"),
    RET_PRICE_ILLEGAL("价格超出合理范围"),
    RET_QTY_ILLEGAL("数量超出合理范围"),
    RET_LESS_MONEY("余额不足"),
    RET_LESS_POSITION("持仓不足"),
    RET_ORDER_TYPE("价格类型出错，['1', '2', 'U']"),
    RET_LOCK_UNDERLY_FAIL("锁定标的物失败"),
    RET_IDCFG_LOSS("tb_id_config中缺少key"),
    RET_SYNCHRON_DATA_NOT_END("交易所数据同步未结束"),
    RET_ORDER_MINQTY_INVALID("RET_ORDER_MINQTY_INVALID"),
    RET_ORDER_MAXPRICE_LEVELS_INVALID("RET_ORDER_MAXPRICE_LEVELS_INVALID"),
    RET_ORDER_SECURITYIDSOURCE_INVALID("RET_ORDER_SECURITYIDSOURCE_INVALID"),
    RET_EXCEED_LIMIT("RET_EXCEED_LIMIT"),
    RET_ORIGINAL_ORDER_NOT_FOUND("RET_ORIGINAL_ORDER_NOT_FOUND"),
    RET_ORIGINAL_ORDER_REJECT("RET_ORIGINAL_ORDER_REJECT"),
    RET_ORIGINAL_ORDER_CANCELLED("RET_ORIGINAL_ORDER_CANCELLED"),
    RET_ORIGINAL_ORDER_FILLED("RET_ORIGINAL_ORDER_FILLED"),
    RET_PASSWORD_ERROR("用户密码错误"),
    RET_USER_STATUS_BLACK("用户状态为黑名单"),
    RET_PARAMS_ERROR("入参出错"),
    RET_ALREADY_LOGIN("用户已登录"),
    RET_HEARTBEAT_TIMEOUT("心跳超时"),
    RET_END("RET_END");

    private String message;

    ClientMgrCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
