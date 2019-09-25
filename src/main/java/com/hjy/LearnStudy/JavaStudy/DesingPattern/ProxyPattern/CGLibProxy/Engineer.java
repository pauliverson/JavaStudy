package com.hjy.LearnStudy.JavaStudy.DesingPattern.ProxyPattern.CGLibProxy;

/**
 * @author huangjunyan
 * @date 2019-07-02 16:42
 */
public class Engineer {
    // 可以被代理
    public void eat() {
        System.out.println("this engineer is eating");
    }

    // final 方法不会被生成的字类覆盖
    public final void work() {
        System.out.println("this engineer is working");
    }

    // private 方法不会被生成的字类覆盖
    private void play() {
        System.out.println("this engineer is playing game");
    }
}
