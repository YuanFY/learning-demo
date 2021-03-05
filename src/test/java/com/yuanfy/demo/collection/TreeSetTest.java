package com.yuanfy.demo.collection;

import org.junit.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author maple.yuan
 * @date 2020-03-14 10:01
 */
public class TreeSetTest {

    @Test
    public void test() {
        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        set.add(2);
        set.add(9);
        set.add(6);
        set.add(19);
        set.add(8);

        System.out.println(set);
    }
}
