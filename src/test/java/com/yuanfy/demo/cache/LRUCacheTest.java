package com.yuanfy.demo.cache;

import com.yuanfy.demo.struct.linklist.Node;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author maple.yuan
 * @date 2019-06-07 16:13
 */
public class LRUCacheTest {

    @Test
    public void test() {
        LRUCache<Integer> cache = new LRUCache<>(5);
        cache.set(1);
        cache.set(2);
        cache.set(3);
        cache.set(4);
        cache.set(5);
        assertNode(cache, 5);
        cache.set(3);
        assertNode(cache, 3);
        cache.set(6);
        assertNode(cache, 6);
    }

    public void assertNode(LRUCache<Integer> cache, Integer first) {
        Node tmpNode = cache.head.next;
        int i = 0;
        while (null != tmpNode) {
            System.out.println("i = " + i + ", data = " + tmpNode.data);
            if (i == 0) {
                Assert.assertEquals(tmpNode.data, first);
            }
            i ++;
            tmpNode = tmpNode.next;
        }
        System.out.println("----------------");
    }
}
