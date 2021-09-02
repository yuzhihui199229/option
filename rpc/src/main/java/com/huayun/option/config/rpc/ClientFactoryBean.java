package com.huayun.option.config.rpc;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * 配置bean工厂类
 */
@Component
public class ClientFactoryBean implements FactoryBean<Object> {

    private Class<?> type;

    @Override
    public Object getObject() throws Exception {
        return Proxy.newProxyInstance(type.getClassLoader(),new Class[]{type},new RPCInvocationHandler(this.type));
    }

    @Override
    public Class<?> getObjectType() {
        return this.type;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }
}
