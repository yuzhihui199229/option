package com.huayun.option.utils;

import com.google.common.collect.Lists;
import com.huayun.option.exception.CopyPropertyException;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 将实体类对象中的数据复制到另一个对象中
 * @author yuzh
 * @date 2021/09/14
 */
public class EntityProtoUtil {

    /**
     * 将一个集合中对象的值拷贝到另一个对象，属性相同即赋值
     *
     * @param source 源数据，将此对象数据取出
     * @param target 目标对象，将取出的数据赋值到该对象中
     * @param <S>    源数据类型
     * @param <T>    目标数据类型
     * @return 被赋值后的目标对象集合
     * @throws CopyPropertyException 自定义异常，通过反射创建对象或调用方法时抛出的异常
     */
    public static <S, T> T EntityToProtobuf(S source, T target) throws CopyPropertyException {

        // 判断传入源数据是否为空，如果空，则抛自定义异常
        if (null == source) {
            throw new CopyPropertyException("数据源为空");
        }
        // 获取源对象的类的详情信息
        Class<?> sClass = source.getClass();
        // 获取源对象的所有属性
        Field[] sFields = sClass.getDeclaredFields();
        // 获取目标对象的类的详情信息
        Class<?> tClass = target.getClass();
        // 获取目标对象的所有方法
        Method[] tMethods = tClass.getDeclaredMethods();
        // 循环取到源对象的单个属性
        for (Field sField : sFields) {
            PropertyDescriptor spd = null;
            PropertyDescriptor tpd = null;
            try {
                spd = new PropertyDescriptor(sField.getName(), sClass);
                Method sMethod = spd.getWriteMethod();
                if (checkSetMet(tMethods, sMethod.getName())) {
                    Method readMethod = spd.getReadMethod();
                    try {
                        if (null != readMethod.invoke(source,new Object[]{})) {
                            tpd = new PropertyDescriptor(sField.getName(), tClass);
                            Method writeMethod = tpd.getWriteMethod();
                            writeMethod.invoke(target, readMethod.invoke(source, new Object[]{}));
                        }
                    } catch (IllegalAccessException|InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }

            } catch (IntrospectionException e) {
                e.printStackTrace();
            }
        }
        // 返回集合
        return target;
    }

    /**
     * 判断对应set方法是否公有
     *
     * @param methods
     * @param fieldSetMet
     * @return
     */
    public static boolean checkSetMet(Method[] methods, String fieldSetMet) {
        for (Method met : methods) {
            if (fieldSetMet.equals(met.getName())) {
                return true;
            }
        }
        return false;
    }
}