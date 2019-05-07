package com.ligz.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 第一个只出现一次的字符
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * author:ligz
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        int[] chars = new int[256];
        char[] c = str.toCharArray();
        Queue<Character> queue = new LinkedList<>();
        for (char s : c) {
            chars[s]++;
            queue.offer(s);
        }
        //当第一个有重复时，poll直到第一个不重复
        while (!queue.isEmpty() && chars[queue.peek()] > 1) queue.poll();
        if (queue.isEmpty()) return -1;
        return str.indexOf(queue.peek());
    }
}
