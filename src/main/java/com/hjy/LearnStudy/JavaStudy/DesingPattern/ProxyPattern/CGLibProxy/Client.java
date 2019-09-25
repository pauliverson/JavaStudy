package com.hjy.LearnStudy.JavaStudy.DesingPattern.ProxyPattern.CGLibProxy;

/**
 * @author huangjunyan
 * @date 2019-07-02 17:01
 */
public class Client {
    public static void main(String[] args) {
        Engineer engineer = (Engineer) CglibProxy.getProxy(new Engineer());

        engineer.eat();
    }
}
