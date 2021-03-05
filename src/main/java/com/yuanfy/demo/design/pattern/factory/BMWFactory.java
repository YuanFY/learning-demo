package com.yuanfy.demo.design.pattern.factory;

import com.yuanfy.demo.design.pattern.common.car.BMWCar;
import com.yuanfy.demo.design.pattern.common.car.Car;

/**
 * @author maple.yuan
 * @date 2021-02-28 11:44
 */
public class BMWFactory implements CarFactory {
    private Car car;
    public BMWFactory() {
        this.car = new BMWCar();
    }

    @Override
    public Car getCar() {
        return this.car;
    }
}
