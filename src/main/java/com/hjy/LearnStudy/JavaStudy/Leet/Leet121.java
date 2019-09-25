package com.hjy.LearnStudy.JavaStudy.Leet;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-09-23 21:25
 */
public class Leet121 {
    public int maxProfit(int[] prices) {
        int minProfit = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0;i < prices.length;i++) {
            minProfit = Math.min(minProfit, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minProfit);
        }
        return maxProfit;
    }

    public int maxProfit_dp(int[] prices) {
        int dp_i_0 = 0, dp_i_1 = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }
}
