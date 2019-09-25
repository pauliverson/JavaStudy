package com.hjy.LearnStudy.JavaStudy.YuanFuDao;

import java.util.*;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-08-24 17:00
 */
public class Class2 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int target = scanner.nextInt();
//        int nums[] = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = scanner.nextInt();
//        }
        System.out.println(Integer.MAX_VALUE);
//        System.out.println(checkSubarraySum(nums, target));

    }

    public static int checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, -1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    res = Math.max(res, map.size());
                }
            } else
                map.put(sum, i);
        }
        return res;
    }

}
