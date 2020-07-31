package com.hjy.LearnStudy.JavaStudy.Leet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leet720 {
    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "b", "appl", "ap", "apply", "apple"};
        System.out.println(longestWord(words));
    }
    public static String longestWord(String[] words) {
//        Arrays.sort(words);
        String ans = "";
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            if (word.length() > ans.length() || (word.length() == ans.length() && word.compareTo(ans) < 0)) {
                boolean good = true;
                for (int i = 1; i < word.length(); ++i) {
                    if (!wordSet.contains(word.substring(0, i))) {
                        good = false;
                        break;
                    }
                }
                if (good) {
                    ans = word;
                }
            }
        }
        return ans;
    }
}
