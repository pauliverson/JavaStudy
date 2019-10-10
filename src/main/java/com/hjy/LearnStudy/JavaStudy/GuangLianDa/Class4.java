package com.hjy.LearnStudy.JavaStudy.GuangLianDa;

import java.util.Arrays;

/**
 * @author pauljy
 * @program LearnJava
 * @description
 * @date 2019-10-10 10:49
 */
public class Class4 {
    public static void main(String[] args) {
        int[] A = new int[]{2,3,4,0,0,0};
        int[] B = new int[]{1,5,6};
        System.out.println(Arrays.toString(mergeTwoSortedArray(A, B, 3, 3)));
    }
    static int[] mergeTwoSortedArray(int[] A, int[] B, int m, int n) {
        int totalTail = m + n - 1;
        int indexOfB = n - 1, indexOfA = m - 1;
        while (indexOfA >= 0 && indexOfB >= 0) {
            while (indexOfB >= 0 && B[indexOfB] >= A[indexOfA]) {
                A[totalTail--] = B[indexOfB--];
            }
            if (indexOfB == -1)
                break;
            while (indexOfA >= 0 && A[indexOfA] >= B[indexOfB]) {
                A[totalTail--] = A[indexOfA--];
            }
        }
        while (indexOfB >= 0) {
            A[totalTail--] = B[indexOfB--];
        }
        return A;
    }
}
