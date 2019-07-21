package com.yuanfy.demo.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 反射机制工具类
 * @author maple.yuan
 * @date 2019-07-20 15:40
 */
public class ReflectionUtil {

    /**
     * 填充对象下的字段值(包括父类中的字段)
     * @param obj 填充bean
     */
    public static void fillRandom(Object obj) throws Exception {
        if (null == obj) {
            return ;
        }
        Class<?> clazz = obj.getClass();
        while (clazz != Object.class) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                // 返回该字段的值
                Object val = field.get(obj);
                if (null == val) {
                    Object value = getRandomValue(field);
                    field.set(obj, value);
                }
            }
            clazz = clazz.getSuperclass();
        }
    }

    private static Object getRandomValue(Field field) throws Exception {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Class<?> type = field.getType();
        if (type == Byte.class) {
            return (byte)random.nextInt(0, 3);
        }
        if (type == BigDecimal.class) {
            return new BigDecimal(random.nextDouble(100, 10000));
        }
        if (type == AtomicLong.class) {
            return new AtomicLong(random.nextLong(100, 10000));
        }
        if (type == AtomicInteger.class) {
            return new AtomicLong(random.nextInt(100, 10000));
        }
        if (Number.class.isAssignableFrom(type)) {
            String value = random.nextInt(0, Short.MAX_VALUE) + "";
            return type.getMethod("valueOf", String.class).invoke(null, value);
        }
        if (type == String.class) {
            return field.getName().substring(0, 1) + random.nextInt(0, Short.MAX_VALUE);
        }
        if (Date.class.isAssignableFrom(type)) {
            long offset = random.nextLong(-3600 * 8, 3600 * 16);
            return new Date(System.currentTimeMillis() + offset * 1000L);
        }
        return null;
    }
}
