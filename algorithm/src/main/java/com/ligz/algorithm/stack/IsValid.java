package com.ligz.algorithm.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 * author:ligz
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串
 */
public class IsValid {
    public boolean isValid(String s) {
        if("".equals(s)) return true;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        for (int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }else {
                if(stack.size() != 0 && map.get(stack.peek()).equals(s.charAt(i))){
                    stack.pop();
                }else {
                    return false;//如果不能匹配直接false
                }
            }
        }
        if(stack.size() == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        IsValid solution = new IsValid();
        solution.isValid("([)]");
    }
}
