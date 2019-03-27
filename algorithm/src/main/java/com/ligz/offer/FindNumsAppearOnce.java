package com.ligz.offer;

import java.util.*;

/**
 * 数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
 * author:ligz
 */
public class FindNumsAppearOnce {

    /**
     * 两个不相等的元素在位级表示上必定会有一位存在不同，将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。
     * diff &= -diff 得到出 diff 最右侧不为 0 的位，也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，
     * 利用这一位就可以将两个元素区分开来
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {//用异或的方法
        int diff = 0;
        for (int num : array) {
            diff ^= num;
        }
        diff &= -diff;//取得最右边为 1 的那一位,即不存在重复的两个元素最右侧不同的那一位.可以把数组分为两边
        for (int num : array) {
            if ((diff & num) == 0) num1[0] ^= num;
            else num2[0] ^= num;
        }
    }

    public void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {//用的是set的方法
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (set.contains(num)) set.remove(num);
            else set.add(num);
        }
        Iterator i = set.iterator();
        num1[0] = (int) i.next();
        num2[0] = (int) i.next();
    }

}
