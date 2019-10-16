package com.hjy.LearnStudy.JavaStudy.TongCheng;

import java.util.Scanner;

/**
 * @author pauljy
 * @program LearnJava
 * @description
 * @date 2019-10-13 20:35
 */
public class Class2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int k = sc.nextInt();
        int endNumber = NumberOfXBetween1AndN_Solution(end, k);
        int startNumber = NumberOfXBetween1AndN_Solution(start, k);
        System.out.println(endNumber - (String.valueOf(start).contains(String.valueOf(k)) ? startNumber - 1 : startNumber));
    }

    public static int NumberOfXBetween1AndN_Solution(int n,int x) {
        if(n<0||x<0||x>9)
            return 0;
        if (x == 0) {
            return getCount0(n);
        }
        int high,low,curr,tmp,i = 1;
        high = n;
        int total = 0;
        while(high!=0){
            high = n/(int)Math.pow(10, i);// 获取第i位的高位
            tmp = n%(int)Math.pow(10, i);
            curr = tmp/(int)Math.pow(10, i-1);// 获取第i位
            low = tmp%(int)Math.pow(10, i-1);// 获取第i位的低位
            if(curr==x){
                total+= high*(int)Math.pow(10, i-1)+low+1;
            }else if(curr<x){
                total+=high*(int)Math.pow(10, i-1);
            }else{
                total+=(high+1)*(int)Math.pow(10, i-1);
            }
            i++;
        }
        return total;
    }

    public static int getCount0(int num) {

        int base = 1;
        int sum = 0;
        int n = num;

        while (n != 0) {
            //区别在于这一行代码，减掉了1
            sum += base * (n / 10 - 1);

            int cur = n % 10;
            if (cur == 0) {
                sum += num % base + 1;
            } else if (cur > 0) {
                sum += base;
            }

            base *= 10;
            n = n / 10;
        }

        return sum;

    }
}
