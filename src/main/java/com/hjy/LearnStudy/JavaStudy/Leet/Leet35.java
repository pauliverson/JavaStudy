package com.hjy.LearnStudy.JavaStudy.Leet;

/**
 * @author huangjunyan
 * @date 2019-07-26 16:54
 */
public class Leet35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0,right = nums.length;
        while(left < right) {
            int mid = (left + right)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] < target) {
                left = mid + 1;
            }
            if(nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }
}
