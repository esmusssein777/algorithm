package com.ligz.algorithm.stack;

import java.util.Stack;

/**
 * 每日温度
 * author:ligz
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，请输入 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的都是 [30, 100] 范围内的整数。
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int size = T.length;
        int [] num = new int[size];
        for (int i = 0; i < size - 1; i++){
            boolean flag = false;
            for (int j = i + 1; j < size; j++){
                if(T[i] < T[j]){
                    num[i] = j - i;
                    flag = true;
                    break;
                }
            }
            if(!flag) num[i] = 0;
        }
        num[size - 1] = 0;
        return num;
    }
}
