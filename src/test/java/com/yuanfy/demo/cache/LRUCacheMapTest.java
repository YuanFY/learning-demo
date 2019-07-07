package com.yuanfy.demo.cache;

import com.yuanfy.demo.struct.linklist.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * @author maple.yuan
 * @date 2019-06-07 16:13
 */
public class LRUCacheMapTest {

    @Test
    public void test() {
        int capacity = 4;
        LruCacheMap<String, String> map = new LruCacheMap<>(capacity);

        map.put("玉树临枫", "本文作者");
        map.put("Andy", "刘德华");
        map.put("eson", "陈奕迅");
        map.put("阅读本文的你", "感谢你的支持");

        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key:" + entry.getKey() + ", value:" + entry.getValue());
        }

        System.out.println("---------对Andy进行了采访-------------");
        map.get("Andy");
        int i = 0;
        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key:" + entry.getKey() + ", value:" + entry.getValue());
            i ++;
            if (i == capacity) {
                Assert.assertEquals("Andy", entry.getKey());
            }
        }
        System.out.println("--------------添加一位成员----------------");
        map.put("James", "23");
        Assert.assertEquals(capacity, map.size());
        i = 0;
        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key:" + entry.getKey() + ", value:" + entry.getValue());
            i ++;
            if (i == capacity) {
                Assert.assertEquals("James", entry.getKey());
            }
        }
    }
}
