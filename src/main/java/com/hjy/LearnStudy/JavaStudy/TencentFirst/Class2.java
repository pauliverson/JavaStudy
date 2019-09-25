package com.hjy.LearnStudy.JavaStudy.TencentFirst;

import java.util.Scanner;

/**
 * @author huangjunyan
 * @date 2019-08-17 20:02
 */
public class Class2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] array = new int[(int)Math.pow(2,n)];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int q = sc.nextInt();
            int gap = (int) Math.pow(2,q);
            int cur = 0;
            while (cur < array.length) {
                reverse(array, cur, cur + gap - 1);
                cur = cur + gap;
            }
            int[] tempArr = new int[array.length];
            for (int j = 0; j < tempArr.length; j++) {
                tempArr[j] = array[j];
            }
            System.out.println(InversePairs(tempArr));
        }

    }

    static int sum ;

    public static int InversePairs(int [] array) {
        sum = 0;
        mergeSort(array, 0, array.length - 1);
        return sum;

    }

    public static int merge(int [] A, int p, int q, int r) {

        int i,j,k;
        int cnt = 0;
        int n1 = q - p + 1;
        int n2 = r - q;
        int left[] = new int[n1 +1];
        int right[] = new int[n2 + 1];
        for(i = 0; i < n1; i++)
            left[i] = A[p + i];
        for(j = 0; j < n2; j++) {
            right[j] = A[ q + 1 + j];
        }

        left[n1] = Integer.MAX_VALUE;// 哨兵
        right[n2] = Integer.MAX_VALUE;//哨兵

        k = p;
        i = 0;
        j = 0;
        while(k <= r) {
            if(left[i] <= right[j]) {
                A[k++] = left[i];
                i++;
                cnt += j;

            }else{
                A[k++] = right[j];

                j++;
            }

        }
        return cnt;
    }
    public static void mergeSort(int A[], int l, int r) {

        if(l < r) {
            int m = (l + r) /2;
            mergeSort(A, l,m);
            mergeSort(A, m + 1, r);
            sum +=merge(A, l, m, r);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void reverse(int[] arr, int start, int end) {
//        System.out.println(start + " " + end);
        for (int i = start; i <= (start + end)/2; i++) {
            swap(arr, i, start + end - i);
        }
    }

}
