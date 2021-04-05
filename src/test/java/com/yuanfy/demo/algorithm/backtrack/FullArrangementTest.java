package com.yuanfy.demo.algorithm.backtrack;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

/**
 * @author maple.yuan
 * @date 2021-04-05 20:51
 */
public class FullArrangementTest {

    @Test
    public void test1() {
        int[] arr = {1, 2, 3, 4};

        List<List<Integer>> fullList = (new FullArrangement()).permute(arr);
        System.out.println(JSON.toJSONString(fullList));
    }

    @Test
    public void test2() {
        int[] arr = {1, 2, 3, 4};

        List<List<Integer>> fullList = (new FullArrangement()).permute2(arr);
        System.out.println(JSON.toJSONString(fullList));
    }
}
