package com.ligz.datastructure.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * author:ligz
 */
public class MyHashSet {
	private int buckets = 1000;//桶
	private int itemBuckets = 10;//确定hash函数,10000个数，1000个桶，每个桶10个数
	private boolean[][] htable;

	/** Initialize your data structure here. */
	public MyHashSet() {
		htable = new boolean[buckets][];
	}

	public void add(int key) {
		int hashKey = hash(key);
		if(htable[hashKey] == null){
			htable[hashKey] = new boolean[itemBuckets];
		}
		htable[hashKey][position(key)] = true;
	}

	public void remove(int key) {
		int hashKey = hash(key);
		if(htable[hashKey] != null && htable[hashKey][position(key)]){
			htable[hashKey][position(key)] = false;
		}
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		int hashKey = hash(key);
		return (htable[hashKey] != null && htable[hashKey][position(key)]);
	}

	private int hash(int key){
		return key % buckets;//hash函数为 x = x % 1000;
	}

	private int position(int key){
		return key / itemBuckets;
	}

}
