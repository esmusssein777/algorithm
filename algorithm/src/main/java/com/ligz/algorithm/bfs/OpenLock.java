package com.ligz.algorithm.bfs;

import java.util.*;

/**
 * 打开转盘锁
 * author:ligz
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 */
public class OpenLock {
    public int openLock(String[] deadends, String target) {//BFS
        Queue<String> queue = new LinkedList<>();
        Set<String> dead = new HashSet(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        int step = 0;
        visited.add("0000");
        queue.offer("0000");

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){//将在队列中的全部拿出来，每一轮处理队列中的所有
                String str = queue.poll();
                if(str.equals(target)) return step;
                if(dead.contains(str)) continue;
                for(int j = 0; j < 4; j++){//针对一个字符进行处理
                    char c = str.charAt(j);
                    String add = str.substring(0, j) + (c == '9' ? 0 : c - '0' + 1) + str.substring(j + 1);
                    String sub = str.substring(0, j) + (c == '0' ? 9 : c - '0' - 1) + str.substring(j + 1);
                    if(!visited.contains(add) && !dead.contains(add)){
                        queue.offer(add);
                        visited.add(add);
                    }
                    if(!visited.contains(sub) && !dead.contains(sub)){
                        queue.offer(sub);
                        visited.add(sub);
                    }
                }

            }
            step++;
        }
        return -1;
    }

}
