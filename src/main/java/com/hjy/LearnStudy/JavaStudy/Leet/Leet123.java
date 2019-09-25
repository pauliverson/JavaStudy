package com.hjy.LearnStudy.JavaStudy.Leet;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-09-23 22:08
 */
public class Leet123 {
    public int maxProfit(int[] prices) {
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i11 = Math.max(dp_i11,  - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
        }
        return dp_i20;
    }
}
