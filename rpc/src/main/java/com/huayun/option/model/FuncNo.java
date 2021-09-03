package com.huayun.option.model;

public enum FuncNo {
    /**
     * 没有使用FuncNo
     */
    FUNC_NO_NULL(null),
    CMD_NEW_ORDER((short)511);       //期权集中竞价交易业务新订单
    private Short code;

    FuncNo(Short code) {
        this.code = code;
    }

    public Short getCode() {
        return code;
    }

    public void setCode(Short code) {
        this.code = code;
    }
}
