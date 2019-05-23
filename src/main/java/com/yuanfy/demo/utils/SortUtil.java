package com.yuanfy.demo.utils;

/**
 * @author maple.yuan
 * @date 2019-05-11 17:11
 */
public class SortUtil {

    /**
     * 冒泡排序: 将元素一个一个往下沉
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (arr.length <= 1) {
            return ;
        }
        int len = arr.length;
        for (int i = 0; i < len; i ++) {
            // 定义终止标志
            boolean swapFlag = false;
            // 每次都会下沉一个， 又因为是j 与 j+1 位置上的元素进行比较，所以 J < len - i - 1
            for (int j = 0; j < len - i - 1; j ++) {
                if (arr[j] > arr[j + 1]) {
                    // 通过交换相互位置来下沉
                    swap(arr, j, j + 1);
                    // 设置交换flag，说明还没有完全有序
                    swapFlag = true;
                }
            }
            if (!swapFlag) {
                // 完全有序则终止循环
                break;
            }
        }
    }

    /**
     * 插入排序：将设数组的前端是有序的，后端是无序的。将无序的往有序的数组中插入
     * 默认有序数组为arr[0]
     * @param arr
     */
    public static void insertSort(int[] arr) {
        if (arr.length <= 1) {
            return ;
        }
        int len = arr.length;
        for (int i = 1; i < len; i ++) {
            // 定义待插入的临时变量
            int tmpValue = arr[i];
            // i 之前的数组，倒序遍历
            int j = i - 1;
            for (; j > -1; j --) {
                if (arr[j] < tmpValue) {
                    // 如果待插入值大于已排序数组中的值，则跳出循环
                    break;
                }
                // 否则需要将值后移
                arr[j+1] = arr[j];
            }
            // 最终将待插入的值赋值给j+1位置上
            arr[j+1] = tmpValue;
        }
    }

    /**
     * 选择排序：每次选择最小的元素与当前元素进行交换
     * @param arr
     */
    public static void selectSort(int[] arr) {
        if (arr.length <= 1) {
            return ;
        }
        int len = arr.length;
        for (int i = 0; i < len-1; i ++) {
            // 最小值
            int minValue = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < len; j ++) {
                // 寻找最小值
                if (minValue > arr[j]) {
                    minValue = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                // 交换最小值
                swap(arr, i, minIndex);
            }
        }
    }

    private static void swap(int[] arr, int i , int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
