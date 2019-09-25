package com.hjy.LearnStudy.JavaStudy.HuaWei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-09-18 19:13
 */
public class Class1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<String> stringList = new ArrayList<>();

        while (in.hasNext()) {
            String str = in.nextLine
                    ();
            if (str.equals(""))
                break;
//            System.out.print("TRUE ");
            stringList.add(str);
        }

//        String[] strs = "44 1 5 71 9 35".split(" ");
//        System.out.println(checkStringsIsLegal(strs));

        for (int i = 0; i < stringList.size(); i++) {
            String string = stringList.get(i);

            String[] strings = string.split(" ");

            System.out.print(checkStringsIsLegal(strings));
            if (i != stringList.size() - 1) {
                System.out.print(" ");
            }
        }
    }

    public static boolean checkStringsIsLegal(String[] strings) {
        String first = strings[0];
        if (first.length() == 1 && strings[strings.length - 1].length() == 1) {
            int cur = 1;
            while (cur < strings.length - 1) {
                if (strings[cur].length() != 2) {
                    break;
                }
                cur++;
            }
            if (cur == strings.length - 1)
                return true;
        }
        if (first.length() == 2 && strings[strings.length - 1].length() == 2) {
            int cur = 1;
            while (cur < strings.length - 1) {
                if (strings[cur].length() != 1) {
                    break;
                }
                cur++;
            }
            if (cur == strings.length - 1)
                return true;
        }
        int lenA = strings[0].length();
        int lenB = strings[1].length();
        if (lenA != lenB) {
            for (int i = 2; i < strings.length; i += 2) {
                if (strings[i].length() != lenA) {
                    return false;
                }
            }
            for (int i = 3; i < strings.length; i += 2) {
                if (strings[i].length() != lenB) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }
}
