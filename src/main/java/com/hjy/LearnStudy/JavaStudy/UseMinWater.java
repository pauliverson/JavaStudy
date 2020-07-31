package com.hjy.LearnStudy.JavaStudy;

import java.util.Arrays;

public class UseMinWater {
    public static void main(String[] args) {
        int[] waters = {3,1,9,10};
        int cnt = 3;
        System.out.println(calcMinWater(waters, cnt));
    }
    public static int calcMinWater(int[] waters, int cnt) {
        Arrays.sort(waters);
        int left = 0, right = cnt - 1;
        int minVal = Integer.MAX_VALUE;
        while (right < waters.length) {
            minVal = Math.min(calcSum(waters, left, right), minVal);
            left++;
            right++;
        }
        return minVal;
    }
    public static int calcSum(int[] waters, int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += (waters[right] - waters[i]);
        }
        return sum;
    }
}
