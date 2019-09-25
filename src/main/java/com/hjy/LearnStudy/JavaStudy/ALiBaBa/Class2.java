package com.hjy.LearnStudy.JavaStudy.ALiBaBa;

import java.util.*;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-08-30 19:52
 */
public class Class2 {

    static String getIndexAndLongest(String users, int maxNum) {
        char[] chars = users.toCharArray();
        return getIndex(chars) + " " + getLongest(chars, maxNum);
    }

    static String getIndex(char[] chars) {
        Map<Integer, Integer> map = new TreeMap<>();
        int max = 0;
        int maxIndex = -1;
        int len = chars.length;
        for (int i = 0; i < chars.length; i++) {
            int count = 0;
            int left = i - 1 < 0 ? len - 1 : i - 1;
            int right = i + 1 >= len ? 0 : i + 1;
            if (chars[i] == 'g')
                continue;
            while (chars[left] != 'b') {
                left = left - 1;
                count++;
                if (left < 0) {
                    left = len - 1;
                }
            }
            while (chars[right] != 'b') {
                right = right + 1;
                count++;
                if (right >= len) {
                    right = 0;
                }
            }
            map.put(i, count);
        }
        for (Integer index : map.keySet()) {
            if (map.get(index) > max) {
                max = map.get(index);
                maxIndex = index;
            }
        }
        return String.valueOf(maxIndex);
    }

    static String getLongest(char[] chars, int maxNum) {
        int len = chars.length;
        int maxLength = 0;
        for (int i = 0; i < len; i++) {
            int find = 0;
            int now = i;
            int count = 0;
            while (find <= maxNum) {
                if (now > len - 1) {
                    now = 0;
                }
                if (chars[now] == 'g') {
                    find++;
                }
                if (count >= len)
                    break;
                if (find > maxNum)
                    break;
                now++;
                count++;
            }
            maxLength = Math.max(maxLength, count - maxNum);
        }
        return String.valueOf(maxLength);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _users;
        try {
            _users = in.nextLine();
        } catch (Exception e) {
            _users = null;
        }
        int maxNum = Integer.parseInt(in.nextLine());
        res = getIndexAndLongest(_users, maxNum);
        System.out.println(res);
    }
}
