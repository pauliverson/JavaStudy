package com.hjy.LearnStudy.JavaStudy.Sina;

import java.util.*;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-08-31 17:00
 */
public class Solution extends LinkedHashMap<Integer, Integer>{
    public static void main(String[] args) {
        Queue q = new LinkedList();
        q.add(1);
        q.add(2);
        System.out.println(q.peek());
        System.out.println(q.peek());

    }
    int cap ;
    public Solution(int capacity) {
        super(capacity, 0.75F, true);
        this.cap = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > cap;
    }
}
