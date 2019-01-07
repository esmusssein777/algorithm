package com.ligz.datastructure.array;

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
		if(digits[digits.length - 1] != 9) {
			digits[digits.length - 1]++;
			return digits;
		}
		int count9 = 0;
		for(int i = 0; i < digits.length - 1; i++) {
			if(digits[i] == 9) {
				count9++;
			}
		}
		if(count9 != digits.length - 1) {
			for(int i = digits.length - 1; i >= 0; i--) {
				
				if(digits[i] != 9) {
					digits[i]++;
					
					return digits;
				}else{
					digits[i] = 0;
				}
			}
		}
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
