package com.huayun.option.model;

/**
 * 发送码，返回码
 */
public enum RetCode {
    SUCCESS(0);
    private int code;

    RetCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
