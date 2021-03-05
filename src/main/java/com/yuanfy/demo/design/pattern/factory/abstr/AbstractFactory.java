package com.yuanfy.demo.design.pattern.factory.abstr;

import com.yuanfy.demo.design.pattern.common.car.Car;

/**
 * @author maple.yuan
 * @date 2021-02-28 11:52
 */
public abstract class AbstractFactory {

    public abstract Car getBenCar();

    public abstract Car getBMWCar();
}
