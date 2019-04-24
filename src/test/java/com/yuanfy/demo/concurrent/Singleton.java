package com.yuanfy.demo.concurrent;

/**
 * @author maple.yuan
 * @date 2019-04-13 23:33
 */
public class Singleton {
    private static Singleton singleton;

    private Singleton() {}

    /**
     * 获取实例对象
     * @return
     */
    public static Singleton getInstance() {
        // 第一重检测
        if (null == singleton) {
            synchronized(Singleton.class) {
                // 第二重检测
                if (null == singleton) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
