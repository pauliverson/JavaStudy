package com.hjy.LearnStudy.JavaStudy.DP;

/**
 * @author huangjunyan
 * @date 2019-07-24 14:54
 */
public class CutRope {
    public static void main(String[] args) {
        System.out.println(cutRope(9));
    }
    public static int cutRope(int N) {
        if(N <= 1)
            return 0;
        if(N == 2)
            return 1;
        if(N == 3)
            return 2;

        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i = 4;i <= N;i++) {
            int max = 0;
            for(int j = 1; j <= N/2;j++) {
                if(i >= j) { //这一步主要是防止 如果N=10这样的情况，j在1-5循环，当i=4的时候会超出长度，防止切多了
                    int temp = dp[j]*dp[i-j];
                    if(max < temp)
                        max = temp;
                }
            }
            dp[i] = max;
        }

        return dp[N];
    }

}
