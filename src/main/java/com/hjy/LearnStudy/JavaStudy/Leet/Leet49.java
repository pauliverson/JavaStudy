package com.hjy.LearnStudy.JavaStudy.Leet;

import java.util.*;

/**
 * @author huangjunyan
 * @date 2019-08-01 23:20
 */
public class Leet49 {
    public static void main(String[] args) {
        String[] strings = new String[]{"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(strings);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<Integer>> map = new HashMap<>();
        for(int i = 0;i < strs.length;i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            List<Integer> list = map.getOrDefault(String.valueOf(chars),new ArrayList<>());
            list.add(i);
            map.put(String.valueOf(chars),list);
        }
        List<List<String>> res = new ArrayList<>();
        for(List<Integer> list : map.values()) {
            List<String> out = new ArrayList<>();
            for(Integer i : list) {
                out.add(strs[i]);
            }
            res.add(out);
        }
        return res;
    }
}
