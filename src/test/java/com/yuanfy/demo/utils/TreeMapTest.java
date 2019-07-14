package com.yuanfy.demo.utils;

import org.junit.Test;

import java.util.*;

/**
 * @author maple.yuan
 * @date 2019-07-13 23:48
 */
public class TreeMapTest {

    @Test
    public void test_consistentHashing() {
        String[] nodes = {"127.0.0.1:1111", "221.226.0.1:2222", "192.168.0.5:111"};
        for (int i = 0; i < nodes.length; i++) {
            System.out.println("[" + nodes[i] + "]的hash值为" +
                    ConsistentHashingUtil.getHash(nodes[i])
                    + ", 被路由到结点[" + ConsistentHashingUtil.getServer(nodes[i]) + "]");
        }
    }
    @Test
    public void test() {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(13, 13);
        map.put(8, 8);
        map.put(17, 17);
        map.put(1, 1);
        map.put(11, 11);
        map.put(15, 15);
        map.put(25, 25);
        map.put(6, 6);
        map.put(14, 14);
        map.put(22, 22);
        map.put(27, 27);

        map.remove(8);
        System.out.println(map);
    }


    @Test
    public void test1() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(6, 6);
        map.put(8, 8);
        map.put(11, 11);
        map.put(13, 13);
        map.put(17, 17);
        map.put(15, 15);
        map.put(14, 14);
        map.put(25, 25);
        map.put(22, 22);
        map.put(27, 27);

        Set<Integer> keySet = map.keySet();

        map.put(2, 2);
        System.out.println(keySet);
    }
}
