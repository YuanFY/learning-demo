package com.yuanfy.demo.utils;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author maple.yuan
 * @date 2019-07-20 11:54
 */
public class MapTest {

    @Test
    public void test() {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 16; i ++) {
            map.put(i, i);
        }
    }
}
