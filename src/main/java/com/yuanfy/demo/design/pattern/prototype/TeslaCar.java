package com.yuanfy.demo.design.pattern.prototype;

/**
 * @author maple.yuan
 * @date 2021-02-28 12:10
 */
public class TeslaCar implements Cloneable {

    public static final String CAR_NAME_PREFIX = "tesla";
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        TeslaCar clone = (TeslaCar)super.clone();
        clone.setCarConfig((CarConfig)this.carConfig.clone());
        return clone;
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
