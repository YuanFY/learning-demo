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

    @Test
    public void test_mergeSort() {
        int[] arr = {3, 4, 1, 7, 6, 5, 2};
        SortUtil.mergeSort(arr, 0, arr.length-1);
        println(arr);
        int tmp = arr[0];
        for (int i = 1; i < arr.length; i ++)  {
            Assert.assertTrue(tmp < arr[i]);
            tmp = arr[i];
        }
    }

    @Test
    public void test_quickSort() {
        int[] arr = {4, 7, 1, 3, 6, 5, 2};
        SortUtil.quickSort(arr, 0, arr.length-1);
        println(arr);
        int tmp = arr[0];
        for (int i = 1; i < arr.length; i ++)  {
            Assert.assertTrue(tmp < arr[i]);
            tmp = arr[i];
        }
    }

    @Test
    public void test_countingSort() {
        int[] arr = {4, 7, 1, 3, 6, 5, 2};
        SortUtil.countingSort(arr, arr.length);
        println(arr);
        int tmp = arr[0];
        for (int i = 1; i < arr.length; i ++)  {
            Assert.assertTrue(tmp <= arr[i]);
            tmp = arr[i];
        }

        int[] arr1 = {2, 5, 3, 0, 2, 3, 0, 3};
        SortUtil.countingSort(arr1, arr1.length);
        println(arr1);
        tmp = arr1[0];
        for (int i = 1; i < arr1.length; i ++)  {
            Assert.assertTrue(tmp <= arr1[i]);
            tmp = arr1[i];
        }
    }

    private void println(int[] arr) {
        for (int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
