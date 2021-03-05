package com.yuanfy.demo.design.pattern.factory;

import com.yuanfy.demo.design.pattern.factory.simple.CarEnum;
import com.yuanfy.demo.design.pattern.factory.simple.CarFactory;
import org.junit.Test;

/**
 * @author maple.yuan
 * @date 2021-02-28 11:39
 */
public class SimpleFactoryTest {

    @Test
    public void test() {
        System.out.println(CarFactory.getCar(CarEnum.BMW).getCarInfo());

        System.out.println(CarFactory.getCar(CarEnum.BENC).getCarInfo());
    }

}
