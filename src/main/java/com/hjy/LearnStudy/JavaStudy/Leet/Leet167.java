package com.hjy.LearnStudy.JavaStudy.Leet;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author pauljy
 * @program LearnJava
 * @description
 * @date 2019-09-27 16:31
 */
public class Leet167 {
//    public int[] twoSum(int[] numbers, int target) {
//        int res[] = new int[2];
//        Map<Integer, Integer> map = new TreeMap<>();
//        for (int i = 0; i < numbers.length; i++) {
//            int find = target - numbers[i];
//            if (map.containsKey(find) && i != map.get(find)) {
//                res[0] = map.get(find) + 1;
//                res[1] = i + 1;
//                break;
//            }
//            map.put(numbers[i], i);
//        }
//        return res;
//    }

    public int[] twoSum(int[] numbers, int target) {
        int res[] = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            if (numbers[left] + numbers[right] == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            }else if (numbers[left] + numbers[right] < target) {
                left++;
            }else {
                right--;
            }
        }
        return res;
    }
}
