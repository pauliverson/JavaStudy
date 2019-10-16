package com.hjy.LearnStudy.JavaStudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author pauljy
 * @program LearnJava
 * @description
 * @date 2019-10-10 20:17
 */
public class XiaoNianGao {

    public static void main(String[] args) {

        //奇数位丢弃
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int n = sc.nextInt();
//            List<Integer> list = new ArrayList<Integer>();
//            for (int i = 0; i <= n; i ++ )
//                list.add(i);
//            while (list.size() != 1) {
//                // 从0开始list移除一次,i再加一次,i始终指向奇数位
//                for (int i = 0; i < list.size(); i = i + 1)
//                    list.remove(i);
//            }
//            System.out.println(list.get(0));
//        }

        //找出字符串中最长的连续数字串
//        Scanner scan=new Scanner(System.in);
//        while(scan.hasNext())
//        {
//            String str1="";
//            String str=scan.nextLine();
//            for(char ch:str.toCharArray()){
//                //将不是数字的字符全部变成a
//                if(ch>='0' && ch<='9'){
//                    str1+=ch;
//                }else{
//                    str1+="a";
//                }
//            }
//            //按a分割
//            String[] strs=str1.split("a");
//            int max=0;//记录最长的连续数字串的长度
//            for(int i=0;i<strs.length;i++){
//                max=strs[i].length()>max?strs[i].length():max;
//            }
//            for(int i=0;i<strs.length;i++){
//                if(strs[i].length()==max)
//                    System.out.print(strs[i]);
//            }
//        }

        int a = 0xCF78DA45, b = 0xAC3689B1;
        System.out.println(a ^ b);
    }
}
