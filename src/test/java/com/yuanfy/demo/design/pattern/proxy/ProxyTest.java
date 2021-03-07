package com.yuanfy.demo.design.pattern.proxy;

import com.alibaba.fastjson.JSON;
import com.yuanfy.demo.design.pattern.common.car.BMWCar;
import com.yuanfy.demo.design.pattern.common.car.BenCar;
import com.yuanfy.demo.design.pattern.common.car.Car;
import com.yuanfy.demo.entity.Person;
import com.yuanfy.demo.entity.UserEntity;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

/**
 * @author maple.yuan
 * @date 2021-03-07 11:19
 */
public class ProxyTest {

    @Test
    public void test_static() {
        BenCar benCar = new BenCar();

        BenCarProxy proxy = new BenCarProxy(benCar);
        System.out.println(proxy.getCarInfo());
    }

    @Test
    public void test_dynamic() {
        BenCar benCar = new BenCar();

        JDKDynamicProxy proxy = new JDKDynamicProxy(benCar);
        Car proxyTarget = (Car) proxy.newProxyInstance();

        System.out.println(proxyTarget.getCarInfo());


        proxy = new JDKDynamicProxy(new BMWCar());
        proxyTarget = (Car) proxy.newProxyInstance();

        System.out.println(proxyTarget.getCarInfo());

    }

    @Test
    public void test_dynamic_cglib() {
        CglibDynamicProxy cglibProxy = new CglibDynamicProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Person.class);
        enhancer.setCallback(cglibProxy);
        Person person = (Person) enhancer.create();
        System.out.println(person.getAge());
    }
}
