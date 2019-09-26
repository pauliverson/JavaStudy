package com.hjy.LearnStudy.JavaStudy.Leet;

import java.util.List;

/**
 * @author pauljy
 * @program LearnJava
 * @description
 * @date 2019-09-25 18:43
 */
public class Leet120 {
    /**
     * @description: 三角形结构的输入，由一个空间复杂度为O(n^2)的解法入手，由底向上，每次取相邻的最小的值加上T(i,j).
     * 然后优化之后，定义一个dp[n]（n为三角形最后一行的元素个数），不考虑最后一行，当遍历到三角形的（i，j）时，
     * dp式变成了dp[i] = min(dp[i], dp[i+1]) + T(i,j).
     * 最后的dp[0]即为所求值
     * @param: [triangle]
     * @return: int
     * @author pauljy
     * @date 2019-09-25
     */

    /**输入形式如下
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     */
     
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int dp[] = new int[triangle.size()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }
        
        for (int i = triangle.size() - 2; i >= 0; i++) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        } 
        return dp[0];
    }
}
