package com.hjy.LearnStudy.JavaStudy.Leet;

/**
 * @author huangjunyan
 * @program test
 * @description LeetCode3
 * @date 2019-08-20 00:03
 */
public class Leet3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("ababcc"));;
    }

//    public static int lengthOfLongestSubstring(String s) {
//        int n = s.length(), ans = 0;
//        Map<Character, Integer> map = new HashMap<>();
//
//        for (int start = 0, end = 0; end < n; end++) {
//            if (map.containsKey(s.charAt(end))) {
//                start = Math.max(map.get(s.charAt(end)),start);
//                System.out.println(start);
//            }
//            ans = Math.max(ans, end - start + 1);
//            map.put(s.charAt(end), end + 1);
//        }
//
//        return ans;
//    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128];

        for (int start = 0, end = 0; end < n; end++) {
            start = Math.max(index[s.charAt(end)], start);
            ans = Math.max(ans, end - start + 1);
            index[s.charAt(end)] = end + 1;
        }

        return ans;
    }
}
