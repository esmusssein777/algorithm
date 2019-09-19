package com.ligz.algorithm.sort;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: ligz
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] ch = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        int max = 0;
        for (int i = 0; i < ch.length; i++) {
            if (!stack.isEmpty()) {
                if (stack.peek() == '(' && ch[i] == ')') {
                    stack.pop();
                    count += 2;
                    max = Math.max(max, count);
                } else if (ch[i] != ')') {
                    count = 0;
                    stack.push(ch[i]);
                }
            } else {
                stack.push(ch[i]);
            }
        }
        System.out.println(max);
    }
}
