package com.yuanfy.demo.algorithm;

import org.junit.Assert;
import org.junit.Test;

/**
 * 斐波那契数列：0、1、1、2、3、5、8、13、21、34
 * @author maple.yuan
 * @date 2020-11-21 11:35
 */
public class FibonacciSequenceTest {

    private static int arr[] = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55,
            89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765};
    /**
     * 递归, 缺点：
     */
    private int algorithm1(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n <= 2) {
            return 1;
        }

        return algorithm1(n - 1) + algorithm1(n - 2);
    }

    /**
     * 平行推法
     */
    private int algorithm2(int n) {
        if (n <= 0) {
            return 0;
        }


        long first = 1;
        long second = 1;
        long rst = 1;

        for (int i = 3; i <= n; i ++) {
            rst = (first + second)%1000000007;
            first = second;
            second = rst;
            System.out.println("i = " + i + ", rst = " + rst);
        }

        return (int)rst;
    }

    private int algorithm3(int n) {
        if(n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

    @Test
    public void test() {
        for (int i = 0; i < 20; i ++) {
            Assert.assertEquals(arr[i], algorithm1(i));
        }


        for (int i = 0; i < 20; i ++) {
            Assert.assertEquals(arr[i], algorithm2(i));
        }

        Assert.assertEquals(407059028,algorithm2(95));
        Assert.assertEquals(407059028,algorithm3(95));
    }

}
