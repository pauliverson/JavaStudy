package com.hjy.LearnStudy.JavaStudy.GuavaStudy.GuavaCollection;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;

/**
 * @author huangjunyan
 * @date 2019-08-17 00:13
 */
public class GuavaCollectionDemo {
    public static void main(String[] args) {
        Multimap<String, Integer> multimap = MultimapBuilder.hashKeys().arrayListValues().build();

        multimap.put("a", 1);
        multimap.put("a", 2);
        multimap.put("b", 3);

        multimap.forEach((a, b) -> System.out.println(a + " " + b));
        System.out.println(multimap.keys());

    }
}
