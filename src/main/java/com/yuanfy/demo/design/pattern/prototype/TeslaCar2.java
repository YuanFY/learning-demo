package com.yuanfy.demo.design.pattern.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author maple.yuan
 * @date 2021-02-28 12:10
 */
public class TeslaCar2 implements Serializable {
    private String name;

    private String type;

    private String color;

    private Double price;

    private CarConfig carConfig;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CarConfig getCarConfig() {
        return carConfig;
    }

    public void setCarConfig(CarConfig carConfig) {
        this.carConfig = carConfig;
    }

    protected Object deepClone() throws Exception {
        //创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            TeslaCar2 o = (TeslaCar2) ois.readObject();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }
    }



    @Override
    public String toString() {
        return "TeslaCar{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", carConfig=" + carConfig +
                '}';
    }
}
