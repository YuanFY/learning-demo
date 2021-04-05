package com.yuanfy.demo.algorithm.backtrack;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * @author maple.yuan
 * @date 2021-04-05 20:48
 */
public class FullArrangement {

    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> fullList = new ArrayList<>(arr.length);

        boolean[] used = new boolean[arr.length];
        Stack<Integer> stock = new Stack<>();

        backTrack(arr, stock, used, fullList);

        return fullList;
    }

    private void backTrack(int[] arr, Stack<Integer> stack, boolean[] used, List<List<Integer>> fullList) {
        if (stack.size() == arr.length) {
            fullList.add(new ArrayList<>(stack));
        }

        for (int i = 0; i < arr.length; i ++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            stack.push(arr[i]);

            backTrack(arr, stack, used, fullList);

            stack.pop();
            used[i] = false;
        }
    }


    public List<List<Integer>> permute2(int[] arr) {
        List<List<Integer>> fullList = new ArrayList<>(arr.length);

        List<Integer> dataList = new ArrayList<>(arr.length);
        for (int i1 : arr) {
            dataList.add(i1);
        }

        this.backTrack(dataList, 0, fullList);

        return fullList;
    }

    private void backTrack(List<Integer> dataList, int start, List<List<Integer>> fullList) {
        if (start == dataList.size()) {
            fullList.add(new ArrayList<>(dataList));
        }

        for (int i = start; i < dataList.size(); i ++) {
            Collections.swap(dataList, start, i);

            System.out.println("递归之前， start = " + start + ", i = " + i + ", dataList = " + JSON.toJSONString(dataList));

            backTrack(dataList, start + 1, fullList);

            System.out.println("递归之后， start = " + start + ", i = " + i + ", dataList = " + JSON.toJSONString(dataList));

            Collections.swap(dataList, start, i);
        }
    }
}
