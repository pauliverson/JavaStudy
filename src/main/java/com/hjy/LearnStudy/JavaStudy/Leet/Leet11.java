package com.hjy.LearnStudy.JavaStudy.Leet;

/**
 * @author huangjunyan
 * @date 2019-07-22 22:15
 */
public class Leet11 {
    public int maxArea(int[] height) {
        int left = 0,right = height.length-1;
        int max = 0;
        while(left < right) {
            max = Math.max(max,Math.abs(height[left] - height[right])*(right-left));
            if(height[right] > height[left])
                left++;
            else
                right--;
        }
        return max;
    }
}
