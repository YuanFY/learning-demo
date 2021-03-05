package com.yuanfy.demo.design.pattern.factory.abstr;

import com.yuanfy.demo.design.pattern.common.car.BMWCar;
import com.yuanfy.demo.design.pattern.common.car.BenCar;
import com.yuanfy.demo.design.pattern.common.car.BusinessBMWCar;
import com.yuanfy.demo.design.pattern.common.car.BusinessBenCar;
import com.yuanfy.demo.design.pattern.common.car.Car;

/**
 * 商务车工厂
 * @author maple.yuan
 * @date 2021-02-28 11:55
 */
public class BusinessCarFactory extends AbstractFactory {
    @Override
    public Car getBenCar() {
        return new BusinessBenCar();
    }

    @Override
    public Car getBMWCar() {
        return new BusinessBMWCar();
    }
}
