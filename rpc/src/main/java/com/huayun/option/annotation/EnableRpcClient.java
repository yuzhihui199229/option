package com.huayun.option.annotation;

import com.huayun.option.config.rpc.InterfaceBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启rpc的服务发现
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(value= InterfaceBeanDefinitionRegistrar.class)
public @interface EnableRpcClient {

    String[] basePackages() default {};

}