package com.hjy.LearnStudy.JavaStudy.GuangLianDa;

/**
 * @author pauljy
 * @program LearnJava
 * @description
 * @date 2019-10-10 10:17
 */
public class Class1 {
    public static void main(String[] args) {
        int array[] = new int[]{1,3,2,8,4,9};
        System.out.println(solution(array, 2));
    }
    static int solution(int[] prices, int fee) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee);
        }
        return dp_i_0;
    }
}
