package com.yuanfy.demo.utils;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author maple.yuan
 * @date 2019-07-14 16:53
 */
public class ConsistentHashingUtil {

    private static TreeMap<Integer, String> nodes = new TreeMap<>();

    /**
     * 待添加入Hash环的服务器列表
     */
    private static String[] servers = {"192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111",
                        "192.168.0.3:111", "192.168.0.4:111"};

    static {
        for (int i = 0; i < servers.length; i ++) {
            int hash = getHash(servers[i]);
            System.out.println("[" + servers[i] + "]加入集合中, 其Hash值为" + hash);
            nodes.put(hash, servers[i]);
        }
    }

    public static int getHash(String str) {
        final int p = 16777619;
        int hash = (int)2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
            hash += hash << 13;
            hash ^= hash >> 7;
            hash += hash << 3;
            hash ^= hash >> 17;
            hash += hash << 5;
            // 如果算出来的值为负数则取其绝对值
            if (hash < 0) {
                hash = Math.abs(hash);
            }
            return hash;
    }


    /**
     * 得到应当路由到的结点
     */
    public static String getServer(String node) {
        // 得到带路由的结点的Hash值
        int hash = getHash(node);
        // 得到大于该Hash值的所有Map
        SortedMap<Integer, String> subMap =
                nodes.tailMap(hash);
        if (subMap.isEmpty()) {
            return nodes.firstEntry().getValue();
        }
        // 第一个Key就是顺时针过去离node最近的那个结点
        Integer i = subMap.firstKey();
        // 返回对应的服务器名称
        return subMap.get(i);
    }
}
