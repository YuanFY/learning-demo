package com.yuanfy.demo;

import com.alibaba.fastjson.JSON;
import org.ehcache.core.EhcacheManager;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求两个有序的 list,求交集
 * @author maple.yuan
 * @date 2020-11-08 09:44
 */
public class Test2 {


    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length; i ++) {
            int temp = arr[i];
            int maxIndex = i;
            // 选择一个最大的
            for (int j = i+1; j < arr.length; j ++) {
                if (temp < arr[j]) {
                    temp = arr[j];
                    maxIndex = j;
                }
            }
            swap(arr, i, maxIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 7, 4, 5, 8};

        sort(arr);

        for (int i = 0; i < arr.length; i ++) {
            System.out.println(arr[i]);
        }
    }

}
