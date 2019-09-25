package com.hjy.LearnStudy.JavaStudy.Leet;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-09-23 21:57
 */
public class Leet122 {

    public int maxProfit(int[] prices) {
        int dp_i_0 = 0, dp_i_1 = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
        }
        return dp_i_0;
    }
}
