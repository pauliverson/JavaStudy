package com.hjy.LearnStudy.JavaStudy.JDK8Study;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-08-26 16:04
 */
public class LambdaStudy {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("TaoBao");
        list.add("ALiYun");
        List<Character> lowerCaseList = list.stream()
                .map(name -> name.charAt(0))
                .map(Character::toLowerCase)
                .collect(Collectors.toList());

        System.out.println(list);
        System.out.println(lowerCaseList);
    }
}
