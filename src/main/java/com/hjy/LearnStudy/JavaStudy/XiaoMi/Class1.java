package com.hjy.LearnStudy.JavaStudy.XiaoMi;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-09-06 19:43
 */
import java.util.*;

public class Class1 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int solution(int[] prices, int budget) {
        int[] dp = new int[budget + 1];
        int temp = budget;
        int len = prices.length - 1;
        Arrays.sort(prices);

        dp[budget] = Integer.MAX_VALUE;
        if (budget < prices[0])
            return -1;
        for (int i = 0; i <= budget; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
        }
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < budget) {
                dp[prices[i]] = 1;
            }
        }
        for (int i = prices[0] + 1 ; i <= budget; i++) {
            for (int j = 0; j < prices.length; j++) {
                if (j - prices[i] >= 0)
                    dp[j] = Math.min(dp[j], dp[j - prices[i]] + 1);
            }
        }
        if (dp[budget] == Integer.MAX_VALUE - 1) {
            return -1;
        }
        return dp[budget];

    }

    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _prices_size = 0;
        _prices_size = Integer.parseInt(in.nextLine().trim());
        int[] _prices = new int[_prices_size];
        int _prices_item;
        for(int _prices_i = 0; _prices_i < _prices_size; _prices_i++) {
            _prices_item = Integer.parseInt(in.nextLine().trim());
            _prices[_prices_i] = _prices_item;
        }

        int _budget;
        _budget = Integer.parseInt(in.nextLine().trim());

        res = solution(_prices, _budget);
        System.out.println(String.valueOf(res));

    }
}

