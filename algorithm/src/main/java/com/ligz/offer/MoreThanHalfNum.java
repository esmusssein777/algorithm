package com.ligz.offer;

/**
 * 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
 * author:ligz
 */
public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 0) return 0;
        int num = 0;
        int res = array[0];
        for (int i = 0; i < array.length; i++) {
            if (res == array[i]) {
                num++;
            } else {
                num--;
                if (num == 0) {
                    res = array[i];
                    num = 1;
                }
            }
        }
        int count = 0;
        for (int a : array) {
            if (a == res) count++;
        }
        return count > array.length / 2 ? res : 0;
    }
}
