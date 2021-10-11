package com.huayun.option.config.autoInsertUpdate;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

/**
 * 自动填充修改
 *
 * @author yuzh
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 使用mp实现添加操作，这个方法执行  createTime为字段  new Date()为现在时间  metaObject
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("create_time", Instant.now().getEpochSecond(), metaObject);
        this.setFieldValByName("update_time", Instant.now().getEpochSecond(), metaObject);
    }

    /**
     * 使用mp实现修改操作，这个方法执行
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("update_time", Instant.now().getEpochSecond(), metaObject);
    }
}