package com.yuanfy.demo.utils;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author maple.yuan
 * @date 2019-06-22 09:43
 */
public class LinkedHashMapTest {

    @Test
    public void test() {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(3, 31);
        map.put(1, 11);
        map.put(2, 21);
        map.put(5, 51);

        printMap(map);
    }

    private void printMap(Map<Integer, Integer> map) {
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("key:" + entry.getKey());
        }
    }
}
