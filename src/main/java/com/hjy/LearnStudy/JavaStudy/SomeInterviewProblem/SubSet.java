package com.hjy.LearnStudy.JavaStudy.SomeInterviewProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjunyan
 * @date 2019-08-17 00:16
 */
public class SubSet {
    public static void main(String[] args) {
        getSubSet(3);
    }

    public static List<List<Integer>> getSubSet(int n) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[n + 1];
        helper(res, new ArrayList<>(), n, 1 , visited);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> out, int n, int start, int[] visited) {
        if (res.contains(out)) {
            return;
        } else {
            res.add(new ArrayList<>(out));
        }

        for (int i = start; i <= n; i++) {
            if (visited[i] != 1) {
                out.add(i);
                visited[i] = 1;
                helper(res, out, n, start + 1,visited);
                visited[i] = 0;
                out.remove(out.size() - 1);
            }
        }
    }

}
