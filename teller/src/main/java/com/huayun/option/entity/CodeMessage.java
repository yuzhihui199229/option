package com.huayun.option.entity;

public enum CodeMessage {
    SUCCESS(0,"成功"),
    ERROR(20001,"失败"),
    TOKEN_ERROR(20002,"token校验不正确");

    CodeMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
