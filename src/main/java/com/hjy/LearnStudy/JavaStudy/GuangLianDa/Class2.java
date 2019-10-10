package com.hjy.LearnStudy.JavaStudy.GuangLianDa;

import java.util.Arrays;
import java.util.List;

/**
 * @author pauljy
 * @program LearnJava
 * @description
 * @date 2019-10-10 10:25
 */
public class Class2 {
    public static void main(String[] args) {
        int people[] = new int[]{1,2,2,3};
        System.out.println(minNumberOfLifeBoat(people, 3));
    }
    static int minNumberOfLifeBoat(int people[], int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int minCount = 0;
        while (left <= right) {
            minCount ++;
            if (people[left] + people[right] <= limit) {
                left ++;
            }
            right --;
        }
        return minCount;
    }
}
