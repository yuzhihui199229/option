package com.huayun.option.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 将符合条件的对应属性值一一赋值更新
 *
 */
public class UpdateValueToOther {


    /**
     * 将后一个类里面的属性值不为null且与前一个属性名一样的属性值赋给前一个属性
     *
     * @param object
     * @param objectDTO
     */
    @SuppressWarnings("rawtypes")
    public static void updateValueIsNotNull(Object object, Object objectDTO) {
        Class classB = object.getClass();
        Class classB1 = objectDTO.getClass();

        Field[] fields = classB1.getDeclaredFields();
        Method[] methods = classB.getDeclaredMethods();

        for (Field field : fields) {
            PropertyDescriptor pd;
            PropertyDescriptor pd1;

            try {
                pd1 = new PropertyDescriptor(field.getName(), classB1);
                Method fieldSetMet1 = pd1.getWriteMethod();
                if (checkSetMet(methods, fieldSetMet1.getName())) {
                    Method get = pd1.getReadMethod();
                    if (null != get.invoke(objectDTO, new Object[]{})) {
                        pd = new PropertyDescriptor(field.getName(), classB);
                        Method fieldSetMet = pd.getWriteMethod();
                        fieldSetMet.invoke(object, get.invoke(objectDTO, new Object[]{}));
                    }
                }

            } catch (IntrospectionException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 查找对应set方法名是否以Id结尾
     *
     * @param methods
     * @param fieldSetMet
     * @return
     */
    public static String checkSetClass(Method[] methods, String fieldSetMet) {
        if (fieldSetMet.endsWith("Id") && fieldSetMet.length() > 5) {
            return (fieldSetMet.substring(0, fieldSetMet.length() - 2));
        }
        return null;
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