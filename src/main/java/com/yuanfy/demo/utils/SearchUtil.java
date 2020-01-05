package com.yuanfy.demo.utils;

import com.sun.tools.javac.util.Assert;

import java.util.UUID;

/**
 * @author maple.yuan
 * @date 2019-07-28 20:54
 */
public class SearchUtil {

    public static int kmp(String parent, String model) {
        int sLen = parent.length();
        int pLen = model.length();
        int i = 0;
        int j = 0;
        int[] next = getNext(model.toCharArray());
        while (i < sLen && j < pLen) {
            if (j == -1 || parent.charAt(i) == model.charAt(j)) {
                i ++;
                j ++;
                continue;
            }
            j = next[j];
        }
        if (j == pLen) {
            return i - j;
        }
        return -1;
    }

    private static int[] getNext(char[] str) {
        int[] next = new int[str.length];
        next[0] = -1;
        int j = 0;
        int k = -1;

        while(j < str.length - 1) {
            if (k == -1 || str[k] == str[j]) {
                k ++;
                j ++;
                next[j] = k;
                continue;
            }
            k = next[k];
        }
        return next;
    }


    public static int searchBm(String parent, String model) {
        assert(parent.length() > model.length());
        int idx = 0;
        while (idx < parent.length()) {
            String prefix = parent.substring(idx, Math.min(idx + model.length(), parent.length()));
            int badIndex = calculateBadChar(prefix.toCharArray(), model.toCharArray());
            int goodIndex = calculateGoodSuffix(prefix.toCharArray(), model.toCharArray());
            int b = Math.max(badIndex, goodIndex);
            if (b == 0) {
                return idx;
            }
            idx += b;
        }
        return -1;
    }

    private static int calculateBadChar(char[] parent, char[] model) {
        int idx = model.length - 1;
        int si = -1;
        int xi = -1;
        while (idx > -1) {
            if (model[idx] == parent[idx]) {
                idx --;
                continue;
            }
            si = idx;
            break;
        }
        while (idx > -1) {
            if (model[idx] == parent[si]) {
                xi = idx;
                break;
            }
            idx --;
        }
        return si - xi;
    }

    private static int calculateGoodSuffix(char[] parent, char[] model) {
        int idx = model.length - 1;
        int len = model.length - 1;
        while (idx > -1) {
            if (model[idx] != parent[idx]) {
                break;
            }
            idx --;
        }
        if (idx == len) {
            return -1;
        }
        if (idx == -1) {
            return 0;
        }
        int start;
        int end = idx + 1;
        do {
            start = -1;
            while (end <= len) {
                if (model[start+1] != model[end]) {
                    end++;
                    break;
                }
                end++;
                start++;
            }
        } while (end <= len);

        if (start < 0) {
            return -1;
        }
        return (end - 1) - start;
    }

    public static void main(String[] args) {
        String parent = "HERE IS A SIMPLE EXBMPLEXAMPLE";
        String model = "EXAMPLE";
        System.out.println(searchBm(parent, model));
        System.out.println(kmp(parent, model));

        parent = "bbc abcdab abcdabcdabde";
        model = "abcdabd";
        System.out.println(searchBm(parent, model));
        System.out.println(kmp(parent, model));

        parent = "abacababc";
        model = "abab";
        System.out.println(searchBm(parent, model));
        System.out.println(kmp(parent, model));

        //System.out.println(Integer.MAX_VALUE);


        int i = 4099;
        System.out.println(i&4095);
    }
}
