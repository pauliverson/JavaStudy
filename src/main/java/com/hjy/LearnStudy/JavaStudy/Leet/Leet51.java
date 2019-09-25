package com.hjy.LearnStudy.JavaStudy.Leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjunyan
 * @date 2019-07-21 17:56
 */
public class Leet51 {
    int n;
    int[] rows;
    int[] mainDia;//记录主对角线
    int[] secDia;//记录次对角线
    int[] queen;
    List<List<String>> res = new ArrayList<>();

    public boolean isNotUnderAttack(int row,int col) {
        int res = rows[col] + mainDia[row - col + 2 * n] + secDia[row + col];
        return res == 0 ? true : false;
    }
    public void placeQueen(int row,int col) {
        queen[row] = col;
        rows[col] = 1;
        mainDia[row - col + 2 * n] = 1;
        secDia[row + col] = 1;
    }
    public void removeQueen(int row,int col) {
        queen[row] = 0;
        rows[col] = 0;
        mainDia[row - col + 2 * n] = 0;
        secDia[row + col] = 0;
    }
    public void addSolution() {
        List<String> out = new ArrayList<>();
        for(int i = 0;i < n;i++) {
            int col = queen[i];
            StringBuilder sb = new StringBuilder();
            for(int j = 0;j < col;j++)
                sb.append(".");
            sb.append("Q");
            for(int j = 0;j < n - col - 1;j++)
                sb.append(".");
            out.add(sb.toString());
        }
        res.add(out);
    }
    public void backtrack(int row) {
        for(int col = 0;col < n;col++) {
            if(isNotUnderAttack(row,col)) {
                placeQueen(row,col);
                if(row + 1 == n)
                    addSolution();
                else
                    backtrack(row + 1);
                removeQueen(row,col);
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        rows = new int[n];
        mainDia = new int[4 * n - 1];
        secDia = new int[2 * n - 1];
        queen = new int[n];

        backtrack(0);
        return res;
    }
}
