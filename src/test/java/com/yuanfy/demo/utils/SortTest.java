package com.yuanfy.demo.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author maple.yuan
 * @date 2019-05-11 17:06
 */
public class SortTest {

    @Test
    public void test_bubbleSort() {
        int[] arr = {2, 1, 7, 6, 5, 8};
        SortUtil.bubbleSort(arr);
        println(arr);
        int tmp = arr[0];
        for (int i = 1; i < arr.length; i ++)  {
            Assert.assertTrue(tmp < arr[i]);
            tmp = arr[i];
        }
    }

    @Test
    public void test_insertSort() {
        int[] arr = {3, 4, 1, 7, 6, 5, 2};
        SortUtil.insertSort(arr);
        println(arr);
        int tmp = arr[0];
        for (int i = 1; i < arr.length; i ++)  {
            Assert.assertTrue(tmp < arr[i]);
            tmp = arr[i];
        }
    }

    @Test
    public void test_selectSort() {
        int[] arr = {3, 4, 1, 7, 6, 5, 2};
        SortUtil.selectSort(arr);
        println(arr);
        int tmp = arr[0];
        for (int i = 1; i < arr.length; i ++)  {
            Assert.assertTrue(tmp < arr[i]);
            tmp = arr[i];
        }
    }

    private void println(int[] arr) {
        for (int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
