package com.yuanfy.demo.design.pattern.proxy;

import com.yuanfy.demo.design.pattern.common.car.BenCar;
import com.yuanfy.demo.design.pattern.common.car.Car;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author maple.yuan
 * @date 2021-03-07 11:30
 */
public class CglibDynamicProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        System.out.println("执行方法前");

        Object invokeSuper = proxy.invokeSuper(obj, args);

        System.out.println("执行方法后");
        return invokeSuper;
    }
}