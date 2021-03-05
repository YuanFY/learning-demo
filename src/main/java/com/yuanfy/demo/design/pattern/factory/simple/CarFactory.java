package com.yuanfy.demo.design.pattern.factory.simple;

import com.yuanfy.demo.design.pattern.common.car.BMWCar;
import com.yuanfy.demo.design.pattern.common.car.BenCar;
import com.yuanfy.demo.design.pattern.common.car.Car;

/**
 * 简单工厂模式有称为静态工厂方法模式 <br/>
 * 优点：<br/>
 * 1、没有暴露具体实现细节；<br/>
 *
 * 缺点：<br/>
 * 1、由于工厂类集中了所有实例的创建逻辑，这就直接导致一旦这个工厂出了问题，所有的客户端都会受到牵连。
 * 2、违背了开放-关闭原则 + 单一职责原则： 由于简单工厂模式的产品是基于一个共同的抽象类或者接口，这样一来，产品的种类增加的时候，即有不同的产品接口或者抽象类的时候，工厂类就需要判断何时创建何种接口的产品，这就和创建何种种类的产品相互混淆在了一起，导致系统丧失灵活性和可维护性。
 * @author maple.yuan
 * @date 2021-01-17 10:27
 */
public class CarFactory {
    public static Car getCar(CarEnum carEnum) {
        switch (carEnum) {

            case BMW:
                return new BMWCar();
            case BENC:
                return new BenCar();
            default:
                return null;
        }
    }
}
