package com.yuanfy.demo.design.pattern.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * @author maple.yuan
 * @date 2021-03-07 11:12
 */
public class JDKDynamicProxy implements InvocationHandler {

    private Object targetObject;

    public JDKDynamicProxy(Object object) {
        this.targetObject = object;
    }

    public Object newProxyInstance() {
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("代理开始：");
        Object invoke = method.invoke(targetObject, args);
        System.out.println("代理结束！");
        return invoke;
    }
}
