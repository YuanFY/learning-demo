package com.yuanfy.demo.algorithm.greed;

import org.junit.Assert;
import org.junit.Test;

/**
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 *
 * 示例 1:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 *
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author maple.yuan
 * @date 2020-12-27 16:42
 */
public class FlowerTest {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int flowNum = flowerbed.length;
        if (flowNum < n) {
            return false;
        }

        int canPlaceFlowerNum = 0;
        int i = -1;
        while (i+1 < flowNum) {
            i ++;
            if (flowerbed[i] == 0) {
                if (i == 0) {
                    if (i + 1 >= flowNum) {
                        canPlaceFlowerNum ++;
                        break;
                    }

                    if (flowerbed[i+1] == 0) {
                        canPlaceFlowerNum ++;
                        flowerbed[i] = 1;
                        continue;
                    }
                    continue;
                }

                if (i == flowNum - 1) {
                    if (flowerbed[i-1] == 0) {
                        canPlaceFlowerNum ++;
                        flowerbed[i] = 1;
                        continue;
                    }
                    continue;
                }

                if (flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                    canPlaceFlowerNum ++;
                    flowerbed[i] = 1;
                }
            }
        }

        return canPlaceFlowerNum >= n;
    }

    @Test
    public void test() {
        int[] flowerbed1 = {0};
        int n = 1;

        Assert.assertTrue(canPlaceFlowers(flowerbed1, n));

        int[] flowerbed2 = {1};
        n = 1;

        Assert.assertFalse(canPlaceFlowers(flowerbed2, n));

        int[] flowerbed3 = {1,0,0,0,1};
        n = 2;

        Assert.assertFalse(canPlaceFlowers(flowerbed3, n));

        int[] flowerbed4 = {0,0,1,0,0};
        n = 2;

        Assert.assertFalse(canPlaceFlowers(flowerbed4, n));
    }
}
