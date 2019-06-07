package com.yuanfy.demo.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author maple.yuan
 * @date 2019-05-26 20:25
 */
public class BinarySearchUtilTest {

    @Test
    public void test() {
        int[] arr = {3, 3, 4, 5, 6, 9};
        int idx = BinarySearchUtil.simpleBinarySearch(arr, 1);
        Assert.assertEquals(idx, -1);
        idx = BinarySearchUtil.simpleBinarySearch(arr, 6);
        Assert.assertEquals(idx, 4);
    }

    @Test
    public void test_sqrt() {
        int sqrt = BinarySearchUtil.sqrt(1);
        Assert.assertEquals(sqrt, 1);
        sqrt = BinarySearchUtil.sqrt(3);
        Assert.assertEquals(sqrt, 1);
        sqrt = BinarySearchUtil.sqrt(4);
        Assert.assertEquals(sqrt, 2);
        sqrt = BinarySearchUtil.sqrt(26);
        Assert.assertEquals(sqrt, 5);
        sqrt = BinarySearchUtil.sqrt(101);
        Assert.assertEquals(sqrt, 10);
        sqrt = BinarySearchUtil.sqrt(10);
        Assert.assertEquals(sqrt, 3);
        sqrt = BinarySearchUtil.sqrt(2147395599);
        Assert.assertEquals(sqrt, 46339);
    }

    @Test
    public void test_findFisrtEquals() {
        int[] arr = {1, 3, 3, 3, 5, 6, 9};
        int idx = BinarySearchUtil.findFirstEquals(arr, 1);
        Assert.assertEquals(idx, 0);
        idx = BinarySearchUtil.findFirstEquals(arr, 3);
        Assert.assertEquals(idx, 1);
    }

    @Test
    public void test_getIndex() {
        int[] arr = {7,8,9,2,3,4,5,6};
        int idx = BinarySearchUtil.getIndex(arr, 5);
        Assert.assertEquals(idx, 6);
        idx = BinarySearchUtil.getIndex(arr, 8);
        Assert.assertEquals(idx, 1);
        idx = BinarySearchUtil.getIndex(arr, 10);
        Assert.assertEquals(idx, -1);

        int[] arr1 = {3,2};
        idx = BinarySearchUtil.getIndex(arr1, 2);
        Assert.assertEquals(idx, 1);

        int[] arr2 = {4, 5, 6, 7, 0, 1, 2};
        idx = BinarySearchUtil.getIndex(arr2, 0);
        Assert.assertEquals(idx, 4);
    }

}
