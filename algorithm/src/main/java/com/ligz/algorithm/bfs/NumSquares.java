package com.ligz.algorithm.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 完全平方数
 * author:ligz
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 */
public class NumSquares {
    public int numSquares(int n) {
        if(n < 2){
            return n;
        }
        int num = 1;
        List<Integer> list = new ArrayList<>();
        while (num * num <= n){//比如12的话将1、4、9放入
            list.add(num * num);
            num++;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        int step = 0;
        while (!queue.isEmpty()){
            step++;
            int size = queue.size();//必须将size先取出来，如果放在循环里面那么size是会变化的。
            for (int i = 0; i < size; i++){
                int poll = queue.poll();
                for (int val : list){
                    int temp = poll;
                    if(temp < val) break;
                    temp = poll - val;
                    if(temp == 0) return step;
                    queue.offer(temp);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        numSquares.numSquares(12);
    }
}
