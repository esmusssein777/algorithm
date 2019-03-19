package com.ligz.offer;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变
 * author:ligz
 */
public class ReOrderArray {
    public void reOrderArray(int [] array) {
        int oddCount = 0;
        for (int i : array) {//先计算出奇数的个数，后面的都是偶数
            if (i % 2 == 1) {
                oddCount++;
            }
        }
        int[] copy = array.clone();//复制一个数组，好拿数据
        int i = 0;
        for (int num : copy) {//奇数放前面，偶数放后面
            if (num % 2 == 1) {
                array[i++] = num;
            }else {
                array[oddCount++] = num;
            }
        }
    }
}
