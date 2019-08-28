package com.ligz.top.comprehensive;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParenthesis {
    /**
     * 目标：生成 n 个符合开闭原则的括号
     * 分析：使用回溯法生成，我们可以开始放一个左括号。 如果它不超过左括号的数量，我们可以放一个右括号
     * 错误：注意 close < open 而不是 close < max
     * 关键：判断 s.length() == max * 2 返回
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        build(list, "", 0, 0, n);
        return list;
    }

    public void build(List<String> list, String s, int open, int close, int max) {
        if (s.length() == max * 2) {
            list.add(s);
            return;
        }
        if (open < max) {
            build(list, s + "(", open + 1, close, max);
        }
        if (close < open) {
            build(list, s + ")", open, close + 1, max);
        }
    }
}
