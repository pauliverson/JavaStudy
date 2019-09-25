package com.hjy.LearnStudy.JavaStudy.Leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author huangjunyan
 * @date 2019-08-05 23:49
 */
public class Leet57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int[][] temp = new int[intervals.length+1][intervals[0].length];
        for(int i = 0;i < intervals.length;i++) {
            temp[i] = intervals[i];
        }
        temp[temp.length-1] = newInterval;

        Arrays.sort(temp, Comparator.comparingInt(a -> a[0]));
        int i = 0;
        while(i < temp.length) {
            int left = temp[i][0];
            int right = temp[i][1];
            while(i < temp.length-1 && temp[i+1][0] <= right) {
                i++;
                right = Math.max(temp[i][1],right);
            }
            res.add(new int[]{left,right});
            i++;
        }
        return res.toArray(new int[0][]);

    }
}
