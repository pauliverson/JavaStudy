package com.hjy.LearnStudy.JavaStudy.Leet;

/**
 * @author huangjunyan
 * @date 2019-07-05 17:12
 */
public class Leet4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n) {
            int[] temps = nums1;nums1 = nums2;nums2 = temps;
            int temp = m;m = n;n = temp;
        }
        int iMin = 0,iMax = m;
        while(iMin <= iMax) {
            int i = (iMin + iMax)/2;
            int j = (m + n + 1)/2 - i;
            if(i < iMax && nums1[i-1] > nums2[j]) {
                iMax = i - 1;
            }
            else if(i > iMin && nums2[j-1] > nums1[i]) {
                iMin = i + 1;
            }else {
                int maxLeft;
                if(i == 0) maxLeft = nums2[j-1];
                else if(j == 0) maxLeft = nums1[i-1];
                else maxLeft = Math.max(nums1[i-1],nums2[j-1]);
                if((m+n)%2==1) return maxLeft;

                int maxRight;
                if(i == m) maxRight = nums2[j];
                else if(j == n) maxRight = nums1[i];
                else maxRight = Math.min(nums1[i],nums2[j]);
                return (maxLeft+maxRight) / 2.0;
            }
        }
        return 0.0;
    }

}
