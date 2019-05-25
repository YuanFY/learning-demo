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

    /**
     * 归并排序
     */
    public static void mergeSort(int[] arr, int start, int end) {
        // 终止条件（就一个元素）
        if (start >= end) {
            return;
        }
        // 中间下标
        int mid = (start + end) / 2;
        // 左边继续分
        mergeSort(arr, start, mid);
        // 右边继续分
        mergeSort(arr, mid+1, end);
        // 当左右两边都不能再分的时候则合并。
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] tmpArr = new int[end-start+1];
        int i = start;
        int j = mid+1;
        int idx = 0;
        // 比较两边的数值，谁小就放入临时数组
        while (i <= mid && j <= end) {
            if (arr[i] > arr[j]) {
                tmpArr[idx ++] = arr[j ++];
            } else {
                tmpArr[idx ++] = arr[i ++];
            }
        }
        // 没遍历完的继续放入临时数组中
        while (i <= mid) {
            tmpArr[idx ++] = arr[i ++];
        }
        while (j <= end) {
            tmpArr[idx ++] = arr[j ++];
        }

        // 从start开始拷贝给原数组
        idx = 0;
        while (start <= end) {
            arr[start ++] = tmpArr[idx ++];
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(arr, left, right);
        quickSort(arr, left, mid);
        quickSort(arr, mid+1, right);
    }

    /**
     * 挖坑法
     */
    public static int partition(int[] arr, int left, int right) {
        int mid = getMiddleIndex(arr, left, right);
        int value = arr[mid];
        // 将中间值要么放在第一位或者放在最后一个位，作为坑位
        swap(arr, mid, left);
        while (left < right) {
            // 如果将中间值放到第一位，那么则从右边开始遍历，将小于中间值填在坑位上
            while (left < right && arr[right] > value) {
                right --;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] < value) {
                left ++;
            }
            arr[right] = arr[left];
        }
        // 弥补坑位产生的重复的值
        arr[left] = value;
        return left;
    }

    /**
     * 左右指针法
     */
    public static int partition1(int[] arr, int left, int right) {
       int mid = getMiddleIndex(arr, left, right);
       int value = arr[mid];
       while (left < right) {
           while (left < right && arr[left] < value) {
               left ++;
           }
           while (left < right && arr[right] > value) {
               right --;
           }
           if (left < right) {
               swap(arr, left , right);
           }
       }
       // 返回中间值所在位置
       return left;
    }

    /**
     * 三数取中法：left mid right
     */
    private static int getMiddleIndex(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (arr[left] <= arr[mid]) {
            if (arr[mid] <= arr[right]) {
                // arr[left] <= arr[mid] <= arr[right]
                return mid;
            }
            if (arr[left] <= arr[right]) {
                // arr[left] <= arr[right] <= arr[mid]
                return right;
            }
            // arr[right] < arr[left] <= arr[mid]
            return left;
        }
        if (arr[left] <= arr[right]) {
            // arr[mid] < arr[left] <= arr[right]
            return left;
        }
        if (arr[mid] < arr[right]) {
            // arr[mid] < arr[right] < arr[left]
            return right;
        }
        // arr[right] <= arr[mid] < arr[left]
        return mid;
    }


    private static void println(int[] arr) {
        for (int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    private static void swap(int[] arr, int i , int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
