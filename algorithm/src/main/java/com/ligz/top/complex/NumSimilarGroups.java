package com.ligz.top.complex;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ligz
 */
public class NumSimilarGroups {
    public int numSimilarGroups(String[] A) {
        if (A == null || A.length == 0) return 0;
        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }
        for (String nums : A) {
            char[] num = nums.toCharArray();
            for (int i = 0; i < num.length - 1; i++) {
                for (int j = i + 1; j < num.length; j++) {
                    char temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                    if (set.contains(String.valueOf(num))) result.add(String.valueOf(num));
                }
            }
        }
        int res = result.size() / 2;
        return res;
    }

    public static void main(String[] args) {
        String[] nums = {"omv", "ovm"};
        NumSimilarGroups numSimilarGroups = new NumSimilarGroups();
        int res = numSimilarGroups.numSimilarGroups(nums);
        System.out.println(res);
    }
}
