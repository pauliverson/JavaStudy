package com.hjy.LearnStudy.JavaStudy.Leet;

import java.util.Arrays;

/**
 * @author pauljy
 * @program LearnJava
 * @description
 * @date 2019-09-25 18:10
 */
public class Leet135 {
    public int candy(int[] ratings) {
        int candy[] = new int[ratings.length];
        Arrays.fill(candy, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }

        int sum = 0;
        for (int num : candy) {
            sum += num;
        }

        return sum;
    }
}
