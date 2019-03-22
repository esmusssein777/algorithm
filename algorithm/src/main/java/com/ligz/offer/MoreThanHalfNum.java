package com.ligz.offer;

/**
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
