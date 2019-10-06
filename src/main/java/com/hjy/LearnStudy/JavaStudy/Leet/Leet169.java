package com.hjy.LearnStudy.JavaStudy.Leet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pauljy
 * @program LearnJava
 * @description
 * @date 2019-10-06 21:39
 */
public class Leet169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (map.get(nums[i]) + 1 > nums.length / 2) {
                    return nums[i];
                } else {
                    int count = map.getOrDefault(nums[i], 0);

                    map.put(nums[i], ++count);
                }
            } else {
                map.put(nums[i], 1);
            }
        }
        return -1;
    }
}
