package com.hjy.LearnStudy.JavaStudy.Sort;

/**
 * @author huangjunyan
 * @date 2019-07-18 20:38
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5,2,2,6,1,3,8,9};
        quickSort(arr,0,arr.length-1);
        for (int i:
             arr) {
            System.out.println(i);
        }
    }
    public static void quickSort(int[] arr,int low,int high) {
        if(arr.length <= 1 && low > high) {
            return;
        }
        if(low < high) {
            int key = partition(arr,low,high);
            quickSort(arr,low,key - 1);
            quickSort(arr,key + 1,high);
        }
    }
    public static int partition(int[] arr,int low,int high) {
        int base = arr[low];
        while(low < high) {
            while(low < high && base <= arr[high]) {
                high --;
            }
            arr[low] = arr[high];
            while(low < high && base >= arr[low]) {
                low ++;
            }
            arr[high] = arr[low];
        }
        arr[low] = base;
        return low;
    }
}
