package com.ligz.algorithm.hash;

import java.net.Inet4Address;
import java.util.*;

/**
 * author:ligz
 */
public class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, val);
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        map.remove(val);
        boolean flag = list.remove((Object)val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int size = map.size();
        Random random = new Random();
        int index = random.nextInt(size);
        return list.get(index);
    }
}
