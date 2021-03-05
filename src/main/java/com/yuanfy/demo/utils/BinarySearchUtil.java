package com.yuanfy.demo.utils;

/**
 * @author maple.yuan
 * @date 2019-05-26 16:53
 */
public class BinarySearchUtil {

    /**
     * 简单二分查找法
     */
    public static int simpleBinarySearch(int[] arr, int findValue) {
        if (arr.length < 1) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > findValue) {
                high = mid - 1;
            } else if (arr[mid] < findValue) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 求x的最大平方根
     * @param x
     * @return
     */
    public static int sqrt(int x) {
        if (x == 1) {
            return x;
        }
        int low = 1;
        int high = x;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            long value = (long)mid * mid;
            if (value == x) {
                return mid;
            }
            if (value > x) {
                value = (long)(mid-1)*(mid-1);
                if ( value <= x) {
                    return mid - 1;
                }
                high = mid - 1;
            } else {
                value = (long)(mid+1)*(mid+1);
                if ( value > x) {
                    return mid;
                } else if (value == x){
                    return mid + 1;
                }
                low = mid + 1;
            }
        }
        return 0;
    }

    public static int findFirstEquals(int[] arr, int value) {
        if (arr.length < 1) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == value) {
                if (mid > 0 && arr[mid-1] == value) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int getIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                // 如果右边是顺序的且最大值都小于target的话，那么就可能在左边
                if (nums[mid] <= nums[high] && target > nums[high]) {
                    high = mid - 1;
                    continue;
                }
                low = mid + 1;
                continue;
            }
            // 如果左边是顺序的且最小值都大于target的话，那么就可能在右边
            if (nums[mid] >= nums[low] && nums[low] > target) {
                low = mid + 1;
                continue;
            }
            high = mid - 1;
        }
        return -1;
    }
}
