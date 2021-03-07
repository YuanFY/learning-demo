package com.yuanfy.demo.java8;

import com.yuanfy.demo.design.pattern.prototype.CarConfig;
import com.yuanfy.demo.design.pattern.prototype.TeslaCar;
import com.yuanfy.demo.design.pattern.prototype.TeslaCar2;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author maple.yuan
 * @date 2021-03-06 07:54
 */
public class SerializableTest {

    @Test
    public void test() throws Exception {
        CarConfig carConfig = new CarConfig();
        carConfig.setEngineName("发动机1");
        carConfig.setSmartConfiguration("智能配置1");

        TeslaCar2 car2 = new TeslaCar2();
        car2.setName("1");
        car2.setCarConfig(carConfig);

        TeslaCar2 car21 = deepClone(car2);
        Assert.assertEquals(car2.getCarConfig().getEngineName(), car21.getCarConfig().getEngineName());
    }

    private TeslaCar2 deepClone(TeslaCar2 car2) throws Exception {
        // 定义一个字节数组输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 定义一个对象输出流
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        // 将对象写入到字节数组输出流中，进行序列化
        oos.writeObject(car2);

        byte[] bytes = baos.toByteArray();

        // 定义一个字节数组输入流
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        // 定义一个对象输出流
        ObjectInputStream ois = new ObjectInputStream(bais);

        return (TeslaCar2) ois.readObject();
    }
}
