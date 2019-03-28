package com.ligz.offer;

import java.util.LinkedList;

/**
 * 孩子们的游戏(圆圈中最后剩下的数)
 * author:ligz
 */
public class LastRemaining {
    public int LastRemaining_Solution(int n, int m) {
        if (n < 0 || m < 0) return 0;
        LinkedList<Integer> list = new LinkedList();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int pre = 0;
        while (list.size() > 1) {//模拟游戏，每次删除走 m - 1 的那位，最后的那个即是结果
            int cur = (pre + m - 1) % list.size();
            list.remove(cur);
            pre = cur;
        }
        return list.size() == 1 ? list.get(0) : 0;
    }
}
