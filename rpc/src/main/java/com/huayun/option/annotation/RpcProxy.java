package com.huayun.option.annotation;

import com.huayun.option.model.FuncNo;
import com.huayun.option.model.ParseType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * rpc的注解类，带有这个注解的接口，都会采用rpc进行调用
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RpcProxy {
   ParseType parseType();
}
