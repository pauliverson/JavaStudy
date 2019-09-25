package com.hjy.LearnStudy.JavaStudy.Leet;

/**
 * @author huangjunyan
 * @date 2019-07-27 13:59
 */
public class Leet41 {
    public static int firstMissingPositive(int[] nums) {
        for(int i = 0;i < nums.length;i++) {
            while(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
                swap(nums,i,nums[i]-1);
        }
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
    public static void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
