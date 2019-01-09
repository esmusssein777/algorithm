package com.ligz.algorithm.array;

import java.util.Arrays;

/**
 * 加一
 * @author ligz
 */
public class AddOne {
	public int[] plusOne2(int[] digits) {//这种不可以。。转成int或者long都会超出大小
		long count = 0;
        for(int i = 0; i < digits.length; i++) {
        	count += digits[i] * Math.pow(10, digits.length -1 - i);
        }
        count++;
        String len = Long.toString(count);
        int[] nd = new int[len.length()];
        for(int i = 0; i < len.length(); i++) {
        	nd[i] = Integer.parseInt(len.substring(i, i+1));
        }
        
        return nd;
    }
	
	public int[] plusOne(int[] digits) {
		if(digits[digits.length - 1] != 9) {//如果最后一个数不是9，那么加完就ok
			digits[digits.length - 1]++;
			return digits;
		}
		int count9 = 0;
		for(int i = 0; i < digits.length - 1; i++) {//计算所有9的数量
			if(digits[i] == 9) {
				count9++;
			}
		}
		if(count9 != digits.length - 1) {//如果不是所有的数字都为9
			for(int i = digits.length - 1; i >= 0; i--) {
				if(digits[i] != 9) {//哪个不是9就+1
					digits[i]++;
					return digits;
				}else{//否则为0
					digits[i] = 0;
				}
			}
		}
		//那么剩下的就是全部为9的情况
		int[] na = new int[digits.length + 1];
		na[0] = 1;
		for(int i = 0; i < digits.length;i++) {
			na[i+1] = 0;
		}
		return na;
    }
	
	public static void main(String[] args) {
		int[] nums = {9,8,7,6,5,4,3,2,1,0};
		int[] nums2 = {8,9,9,9};
		AddOne o = new AddOne();
		System.out.println(Arrays.toString(o.plusOne2(nums)));
		System.out.println(Arrays.toString(o.plusOne(nums2)));
	}
	

}
