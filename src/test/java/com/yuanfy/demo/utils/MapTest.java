package com.yuanfy.demo.utils;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author maple.yuan
 * @date 2019-07-20 11:54
 */
public class MapTest {

    @Test
    public void test() {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 16; i ++) {
            map.put(i, i);
        }
    }


    @Test
    public void test2() throws Exception {
        String fileName = "/Users/maple.janes/Downloads/1.rtf";

        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));

        String line;
        Map<Integer, Integer> map = new HashMap<>();
        while ((line=br.readLine())!=null) {
            if (line.trim().length() == 0 || "\\f1 \\".equals(line)) {
                continue;
            }
            int hash = Math.abs(spread(line.hashCode())) % 6;
            Integer integer = map.computeIfAbsent(hash, v -> 0);
            map.put(hash, integer + 1);
            if (hash == 0){
                System.out.println(line);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static final int HASH_BITS = 0x7fffffff;
    static final int spread(int h) {
        return (h ^ (h >>> 16)) & HASH_BITS;
    }
}
