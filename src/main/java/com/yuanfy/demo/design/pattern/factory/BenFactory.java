package com.yuanfy.demo.design.pattern.factory;

import com.yuanfy.demo.design.pattern.common.car.BenCar;
import com.yuanfy.demo.design.pattern.common.car.Car;

/**
 * 工厂模式，<br/>
 * 优点: 1、一个调用者想创建一个对象，只要知道其名称就可以了。 <br/>
 * 2、扩展性高，如果想增加一个产品，只要扩展一个工厂类就可以。<br/>
 * 3、屏蔽产品的具体实现，调用者只关心产品的接口<br/>
 *
 * 缺点：每次增加一个产品时，都需要增加一个具体类和对象实现工厂，使得系统中类的个数成倍增加，<br/>
 * 在一定程度上增加了系统的复杂度，同时也增加了系统具体类的依赖<br/>
 * @author maple.yuan
 * @date 2021-02-28 11:42
 */
public class BenFactory implements CarFactory {


    private Car car;
    public BenFactory() {
        this.car = new BenCar();
    }

    @Override
    public Car getCar() {
        return this.car;
    }
}
