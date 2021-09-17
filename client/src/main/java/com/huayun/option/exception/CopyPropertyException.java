package com.huayun.option.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CopyPropertyException extends Exception{
    private String message;
}
