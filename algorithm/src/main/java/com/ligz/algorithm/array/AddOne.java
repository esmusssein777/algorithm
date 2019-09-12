package com.ligz.algorithm.array;

import java.util.Arrays;

/**
 * 加一
 * @author ligz
 */
public class AddOne {
	/**
	 * leetcode大神解答
	 *
	 * @param digits
	 * @return
	 */
	public int[] plusOne3(int[] digits) {
		int n = digits.length;
		for(int i=n-1; i>=0; i--) {//其实和我的思路一脉相承。。。。我擦，我就像个zz
			if(digits[i] < 9) {
				digits[i]++;
				return digits;
			}

			digits[i] = 0;
		}
		int[] newNumber = new int [n+1];
		newNumber[0] = 1;
		return newNumber;
	}


}
