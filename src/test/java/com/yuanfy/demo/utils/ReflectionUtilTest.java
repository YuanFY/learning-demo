package com.yuanfy.demo.utils;

import com.yuanfy.demo.entity.UserEntity;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author maple.yuan
 * @date 2019-07-20 17:44
 */
public class ReflectionUtilTest {
    @Test
    public void test() throws Exception {
        UserEntity user = new UserEntity();
        ReflectionUtil.fillRandom(user);
        System.out.println(user.getName());
        System.out.println(user.getCreateTime());
        System.out.println(user.getMoney());
        System.out.println(user.id);
    }

    @Test
    public void test1() throws Exception {
        UserEntity user = new UserEntity();
        Class<? extends UserEntity> aClass = user.getClass();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName());
        }
    }
}
