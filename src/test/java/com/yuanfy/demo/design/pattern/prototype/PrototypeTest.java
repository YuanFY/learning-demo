package com.yuanfy.demo.design.pattern.prototype;

import com.yuanfy.demo.design.pattern.common.car.BenCar;
import com.yuanfy.demo.design.pattern.common.car.Car;
import org.junit.Test;

/**
 * @author maple.yuan
 * @date 2021-02-28 12:12
 */
public class PrototypeTest {

    @Test
    public void test() throws CloneNotSupportedException {
        CarConfig carConfig = new CarConfig();
        carConfig.setEngineName("发动机1");
        carConfig.setSmartConfiguration("智能配置1");

        TeslaCar car1 = new TeslaCar();
        car1.setName("1");
        car1.setCarConfig(carConfig);




        TeslaCar car2 = (TeslaCar)car1.clone();
        car2.getCarConfig().setEngineName("发动机v2");

        System.out.println(car1.toString());
        System.out.println(car2.toString());
    }

    @Test
    public void test2() throws Exception {
        CarConfig carConfig = new CarConfig();
        carConfig.setEngineName("发动机1");
        carConfig.setSmartConfiguration("智能配置1");

        TeslaCar2 car1 = new TeslaCar2();
        car1.setName("1");
        car1.setCarConfig(carConfig);




        TeslaCar2 car2 = (TeslaCar2)car1.deepClone();
        car2.getCarConfig().setEngineName("发动机v2");

        System.out.println(car1.toString());
        System.out.println(car2.toString());
    }
}
