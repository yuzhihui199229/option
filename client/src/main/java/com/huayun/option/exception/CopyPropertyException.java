package com.huayun.option.exception;

import com.google.protobuf.Message;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CopyPropertyException extends Exception{
    private String message;
}
