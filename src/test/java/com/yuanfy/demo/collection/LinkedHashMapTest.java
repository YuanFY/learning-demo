package com.yuanfy.demo.collection;

import com.yuanfy.demo.cache.LruCacheMap;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author maple.yuan
 * @date 2020-03-14 10:19
 */
public class LinkedHashMapTest {

    @Test
    public void test() {
        Map<String, String> map = new LinkedHashMap<>();

        map.put("玉树临枫", "本文作者");
        map.put("Andy", "刘德华");
        map.put("eson", "陈奕迅");
        map.put("阅读本文的你", "感谢你的支持");

        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key:" + entry.getKey() + ", value:" + entry.getValue());
        }
    }
}
