package com.hjy.LearnStudy.JavaStudy.Leet;

/**
 * @author huangjunyan
 * @date 2019-07-26 16:16
 */
public class Leet34 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1};
        int[] res = searchRange(nums,1);
        for(int i : res) {
            System.out.println(i);
        }
    }
    public static int[] searchRange1(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        int index = -1;
        int left = 0,right = nums.length - 1;
        while(left <= right) {
            int mid = (right + left)/2;
            if(nums[mid] == target) {
                index = mid;
                break;
            }
            if(nums[mid] < target)
                left = mid + 1;
            else if(nums[mid] > target)
                right = mid - 1;
        }
        if(index == -1)
            return res;
        right = index;
        System.out.println(right);
        while(right <= nums.length-2 && nums[right] == nums[right + 1] ) {
            right++;
        }
        left = index;
        while(left >= 1 && nums[left] == nums[left - 1] ) {
            left--;
        }
        res[0] = left;
        res[1] = right;
        return res;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        int left = extremeInsertionIndex(nums,target,true);

        if(left == nums.length || nums[left] != target)
            return res;

        res[0] = left;
        res[1] = extremeInsertionIndex(nums,target,false) - 1;
        return res;
    }
    public static int extremeInsertionIndex(int[] nums,int target,boolean left) {
        int low = 0,high = nums.length;
        while(low < high) {
            int mid = (low + high)/2;
            if(nums[mid] > target || (left && nums[mid] == target)) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}
