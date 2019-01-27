package com.ligz.algorithm.hash;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 两个数组的交集
 * author:ligz
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 */
public class Intersection {
	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set = new HashSet<>();
		HashSet<Integer> result = new HashSet<>();
		for(int i : nums1){
			set.add(i);
		}
		for(int i : nums2){
			if(set.contains(i)){
				result.add(i);
			}
		}
		int[] intersection = new int[result.size()];
		Iterator<Integer> iterator = result.iterator();
		for(int i = 0; i < result.size(); i++){
			intersection[i] = iterator.next();
		}
		return intersection;
	}

	public static void main(String[] args) {
		int[] num1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		Intersection intersection = new Intersection();
		intersection.intersection(num1,nums2);
	}
}
