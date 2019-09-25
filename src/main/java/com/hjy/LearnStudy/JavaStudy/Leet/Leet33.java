package com.hjy.LearnStudy.JavaStudy.Leet;

/**
 * @author huangjunyan
 * @date 2019-07-26 16:06
 */
public class Leet33 {
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < nums[right]) {
                if(nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else right = mid - 1;
            }
            else {
                if(nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }
}
