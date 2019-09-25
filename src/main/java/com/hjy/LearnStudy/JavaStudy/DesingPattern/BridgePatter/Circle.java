package com.hjy.LearnStudy.JavaStudy.DesingPattern.BridgePatter;

import java.util.List;

/**
 * @author huangjunyan
 * @date 2019-07-11 12:07
 */
public class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    void test(List<?> list){
        for(Object object : list) {
            System.out.println(object);
        }
    }
    void draw() {
        drawAPI.drawCircle(radius,x,y);
    }

    public <E> void printInfo(E e) {
        System.out.println(e);
    }
    public <K,V> void printPair(K k,V v) {
        System.out.println(k+"+"+v);
    }
    public <T> T print(T t) {
        System.out.println(t);
        return t;
    }
}
