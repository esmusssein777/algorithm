package com.ligz.algorithm.hash;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * author:ligz
 */
public class LRUCache {

    private Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        map = new LRUCacheMap<>(capacity);
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        return map.get(key);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    private static class LRUCacheMap<K, V> extends LinkedHashMap<K, V> {
        int maxCapacity;

        LRUCacheMap(int maxCapacity) {
            super(16, 0.75f, true);
            this.maxCapacity = maxCapacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > maxCapacity;
        }
    }
}
