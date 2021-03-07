package com.yuanfy.demo.design.pattern.proxy;

import com.yuanfy.demo.design.pattern.common.car.BenCar;
import com.yuanfy.demo.design.pattern.common.car.Car;

/**
 * 静态代理
 * @author maple.yuan
 * @date 2021-03-07 11:08
 */
public class BenCarProxy implements Car {

    private BenCar benCar;

    public BenCarProxy(BenCar benCar) {
        this.benCar = benCar;
    }

    @Override
    public String getCarInfo() {
        return benCar.getCarInfo();
    }
}
