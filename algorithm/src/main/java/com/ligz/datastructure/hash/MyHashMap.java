package com.ligz.datastructure.hash;

/**
 * author:ligz
 */
public class MyHashMap {
	private int buckets = 1000;
	private int itemBucket = 1000;// 1000000 / 1000 = 1000
	private int[][] htable;


	/** Initialize your data structure here. */
	public MyHashMap() {
		htable = new int[buckets][];
	}

	private int hash(int key){
		return key % buckets;
	}

	private int position(int key){
		return key / itemBucket;
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		int hashKey = hash(key);
		if(htable[hashKey] == null){
			htable[hashKey] = new int[itemBucket];
			for(int i = 0; i < itemBucket; i++){
				htable[hashKey][i] = -1;
			}
		}
		htable[hashKey][position(key)] = value;
	}

	/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	public int get(int key) {
		int hashKey = hash(key);
		if(htable[hashKey] == null || htable[hashKey][position(key)] == -1){
			return -1;
		}
		return htable[hashKey][position(key)];
	}

	/** Removes the mapping of the specified value key if this map contains a mapping for the key */
	public void remove(int key) {
		int hashKey = hash(key);
		if(htable[hashKey] != null){
			htable[hashKey][position(key)] = -1;
		}
	}
}
