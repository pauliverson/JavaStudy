package com.hjy.LearnStudy.JavaStudy.Leet;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author pauljy
 * @program LearnJava
 * @description
 * @date 2019-10-09 17:29
 */
public class Leet179 {
    public static void main(String[] args) {
        int nums[] = new int[]{999999998,999999997,999999999};
        System.out.println(largestNumber(nums));
    }
//    private static class LargerNumberComparator implements Comparator<String> {
//        @Override
//        public int compare(String a, String b) {
//            String order1 = a + b;
//            String order2 = b + a;
//            return order2.compareTo(order1);
//        }
//    }

    public static String largestNumber(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, (String a, String b) -> (b + a).compareTo(a + b));

        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }
}
