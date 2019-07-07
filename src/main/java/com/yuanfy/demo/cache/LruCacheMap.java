package com.yuanfy.demo.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author maple.yuan
 * @date 2019-06-29 21:22
 */
public class LruCacheMap<K, V> extends LinkedHashMap<K, V> {

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int limit;

    public LruCacheMap(int initialCapacity) {
        super(initialCapacity, DEFAULT_LOAD_FACTOR, true);
        this.limit = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > limit;
    }
}
