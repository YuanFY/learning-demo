package com.yuanfy.demo.design.pattern.prototype;

import java.io.Serializable;

/**
 * @author maple.yuan
 * @date 2021-02-28 12:17
 */

public class CarConfig implements Serializable,Cloneable{
    private String engineName;

    private String smartConfiguration;

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public String getSmartConfiguration() {
        return smartConfiguration;
    }

    public void setSmartConfiguration(String smartConfiguration) {
        this.smartConfiguration = smartConfiguration;
    }

    @Override
    public String toString() {
        return "CarConfig{" +
                "engineName='" + engineName + '\'' +
                ", smartConfiguration='" + smartConfiguration + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
