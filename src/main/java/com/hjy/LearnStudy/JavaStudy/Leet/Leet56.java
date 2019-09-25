package com.hjy.LearnStudy.JavaStudy.Leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author huangjunyan
 * @date 2019-08-05 21:10
 */
public class Leet56 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2},{6,9},{2,3},{4,5}};
        int[][] res = merge(intervals);
        for(int[] nums : res) {
            for(int i : nums) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if(intervals == null || intervals.length == 0)
            res.toArray(new int[0][]);
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int i = 0;
        while(i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while(i < intervals.length - 1 && intervals[i+1][0] <= right) {
                i++;
                right = Math.max(intervals[i][1],right);
            }
            res.add(new int[]{left,right});
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
