package com.hjy.LearnStudy.JavaStudy.Leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author huangjunyan
 * @date 2019-07-19 09:05
 */
public class Leet46 {
    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'b', 'c'};
        List<List<Character>> list = new ArrayList<>();
        helper(chars, 0, chars.length - 1);
    }

    //    public List<List<Integer>> permute(int[] nums) {
//
//    }
    public static void helper(char[] chr, int start, int end) {
        if (end <= 1)
            return;
        if (start == end) {
            System.out.println(chr);
        } else {
            for (int i = start; i <= end; i++) {
                swap(chr, i, start);
                helper(chr, start + 1, end);
                swap(chr, start, i);
            }
        }
    }

    public static void swap(char[] chr, int i, int j) {
        char temp = chr[i];
        chr[i] = chr[j];
        chr[j] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        helper(res, list, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> nums, int start) {
        if (start == nums.size()) {
            res.add(new ArrayList(Collections.singleton(nums)));
            return;
        } else {
            for (int i = start; i < nums.size(); i++) {
                swap(nums, i, start);
                helper(res, nums, start + 1);
                swap(nums, i, start);
            }
        }
    }

    public void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}
