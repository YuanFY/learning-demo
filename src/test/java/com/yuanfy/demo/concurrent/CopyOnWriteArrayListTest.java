package com.yuanfy.demo.concurrent;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.*;


/**
 * @author maple.yuan
 * @date 2020-04-12 15:59
 */
public class CopyOnWriteArrayListTest {

    @Test
    public void test() {
        CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(new Integer[]{1, 3, 5, 78});

        Iterator<Integer> iterator = numbers.iterator();
        numbers.add(100);
        List<Integer> result = new LinkedList<>();
        iterator.forEachRemaining(result::add);
        System.out.println(result);

        Iterator<Integer> iterator2 = numbers.iterator();
        numbers.remove(3);
        List<Integer> result2 = new LinkedList<>();
        iterator2.forEachRemaining(result2::add);
        System.out.println(result2);
    }

    @Test
    public void test_remove(){
        CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(new Integer[]{1, 3, 5, 78});
        Iterator<Integer> integerIterator = numbers.iterator();
        while (integerIterator.hasNext()) {
            integerIterator.remove();
        }
    }
}
