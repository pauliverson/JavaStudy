package com.hjy.LearnStudy.JavaStudy.Leet;

/**
 * @author huangjunyan
 * @date 2019-07-26 14:42
 */
public class Leet31 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        nextPermutation(nums);
        for(int i : nums) {
            System.out.println(i);
        }
    }
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while(i >= 1 && nums[i-1] >= nums[i]) {
            i--;
        }
        if(i >= 1) {
            int j = nums.length - 1;
            while(j >= 0 && nums[j] <= nums[i-1])
                j--;
            swap(nums,i-1,j);
        }
        reverse(nums,i,nums.length-1);
    }
    public static void reverse(int[] nums,int i,int j) {
        while(i < j) {
            swap(nums,i++,j--);
        }
    }
    public static void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
