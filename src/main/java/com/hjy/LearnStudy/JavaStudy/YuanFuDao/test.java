package com.hjy.LearnStudy.JavaStudy.YuanFuDao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-08-24 19:12
 */
public class test {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(3);
        list.add(5);
        for (int i = 0; i < 5; ++i) {
            int v = list.get(i);
            if (v % 2 == 0) {
                list.remove(v);
            }
        }
    }
}
