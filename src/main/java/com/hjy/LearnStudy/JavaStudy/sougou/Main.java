package com.hjy.LearnStudy.JavaStudy.sougou;


import java.util.Arrays;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-09-16 19:42
 */
public class Main {
    public static int calSeq(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        Arrays.sort(nums);
        int diffMax = nums[length - 1] - nums[0];
        int[][] dp = new int[length][diffMax + 1];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= diffMax; j++) {
                dp[i][j] = 1;
            }
        }
        int longestLength = 1;
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int temp = nums[i] - nums[j];
                dp[i][temp] = dp[j][temp];
                longestLength = Math.max(longestLength, dp[i][temp]);
            }
            return longestLength;
        }
        return 0;
    }
    public static void main(String[] args) {

    }
}
