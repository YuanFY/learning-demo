package com.yuanfy.demo;

import com.alibaba.fastjson.JSON;
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

    @Test
    public void test() {
        List<Integer> list1 = Arrays.asList(1,3,5,7,8,9);
        List<Integer> list2 = Arrays.asList(2,3,4,5,6,7, 8);

        List<Integer> rstList = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {

            Integer value1 = list1.get(i);
            Integer value2 = list2.get(j);
            if (value1.equals(value2)) {
                rstList.add(value1);
                i++;
                j++;
                continue;
            }

            if (value1.compareTo(value2) < 0) {
                i++;
                continue;
            }

            j++;
        }

        Assert.assertEquals(4, rstList.size());
        System.out.println(JSON.toJSON(rstList));
    }
}
