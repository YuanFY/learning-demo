package com.yuanfy.demo.design.pattern.common.car;

/**
 * @author maple.yuan
 * @date 2021-01-17 10:30
 */
public class BenCar implements Car {

    private String name;

    private String type;

    private String color;

    private Double price;

    @Override
    public String getCarInfo() {
        return "I'm big ben";
    }

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
}
