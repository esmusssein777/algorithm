package com.ligz.algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * author:ligz
 */
public class LetterCombinations {
    String[] num = {" ","","abc","def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        dfs(digits, 0 , "");
        return list;
    }

    private void dfs(String digits, int index, String s) {
        if (index == digits.length()) {
            list.add(s);
            return;
        }

        char d = digits.charAt(index);
        String letter = num[d - '0'];
        for (int i = 0; i < letter.length(); i++) {
            dfs(digits, index + 1, s + num[i]);
        }
        return;
    }
}
