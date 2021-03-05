package com.yuanfy.demo.design.pattern.factory.simple;

/**
 * @author maple.yuan
 * @date 2021-01-17 10:31
 */
public enum CarEnum {
    BMW(1),
    BENC(2);

    private int type;

    private CarEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
