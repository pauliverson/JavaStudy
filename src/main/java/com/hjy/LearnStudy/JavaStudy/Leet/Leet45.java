package com.hjy.LearnStudy.JavaStudy.Leet;

/**
 * @author huangjunyan
 * @date 2019-07-30 23:59
 */
public class Leet45 {
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0;i < nums.length - 1;i++) {
            maxPosition = Math.max(maxPosition,nums[i] + i);
            if(i == end) {
                end = maxPosition;
                steps++;
                if(end == nums.length - 1)
                    break;
            }
        }
        return steps;
    }
}
