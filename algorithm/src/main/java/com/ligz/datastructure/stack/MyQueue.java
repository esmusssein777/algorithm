package com.ligz.datastructure.stack;

import java.util.Stack;

/**
 * 用栈实现队列
 * author:ligz
 */
public class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack();
        s2 = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(s1.size() == 0){
            s1.push(x);
            return;
        }
        while (s1.size() > 0){
            s2.push(s1.pop());
        }
        s1.push(x);
        while (s2.size() > 0){
            s1.push(s2.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s1.pop();
    }

    /** Get the front element. */
    public int peek() {
        return s1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}
