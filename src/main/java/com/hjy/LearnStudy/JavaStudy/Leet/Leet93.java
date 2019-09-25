package com.hjy.LearnStudy.JavaStudy.Leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjunyan
 * @date 2019-07-28 12:21
 */
public class Leet93 {
    volatile Integer count = new Integer(1);

    public static void main(String[] args) {
//        List<String> list = restoreIpAddresses("25511112211");
//        for(String str : list) {
//            System.out.println(str);
//        }


    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, 0, "", res);
        return res;
    }

    public static void helper(String s, int n, String out, List<String> res) {
        if (n == 4) {
            if (s.isEmpty())
                res.add(out);
            return;
        }
        for (int k = 1; k <= 3; k++) {
            if (s.length() >= k) {
                int val = Integer.parseInt(s.substring(0, k));
                if (val > 255 || k != String.valueOf(val).length())
                    continue;
                helper(s.substring(k), n + 1, out + s.substring(0, k) + (n == 3 ? "" : "."), res);
            }
        }
    }

    public void add() {

        synchronized (count) {
            count++;
        }
    }
}
