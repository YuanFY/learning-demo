package com.yuanfy.demo.design.pattern.factory.abstr;

import com.yuanfy.demo.design.pattern.common.car.BMWCar;
import com.yuanfy.demo.design.pattern.common.car.BenCar;
import com.yuanfy.demo.design.pattern.common.car.BusinessBMWCar;
import com.yuanfy.demo.design.pattern.common.car.BusinessBenCar;
import com.yuanfy.demo.design.pattern.common.car.Car;

/**
 * 普通车工厂
 * @author maple.yuan
 * @date 2021-02-28 11:55
 */
public class CommonCarFactory extends AbstractFactory {
    @Override
    public Car getBenCar() {
        return new BenCar();
    }

    @Override
    public Car getBMWCar() {
        return new BMWCar();
    }
}
