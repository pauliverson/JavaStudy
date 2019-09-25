package com.hjy.LearnStudy.JavaStudy.JDK8Study;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-08-26 16:20
 */
public class StreamStudy {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, null, 3, null, 5, 6, null);
        System.out.println(list.stream().filter(number -> number != null).count());


        Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);

        List<Integer> list2 = Lists.newArrayList(1, 1, null, null, 2, 3, 4, null, 6, 7, 8, 9, 10);
        System.out.println(list2.stream().filter(num -> num != null)
                .distinct().mapToInt(num -> num * 2).peek(System.out::println).skip(2).limit(5).sum());

        List<Integer> ints = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("ints sum is:" + ints.stream().reduce(0, (sum, item) -> sum + item));
    }
}
