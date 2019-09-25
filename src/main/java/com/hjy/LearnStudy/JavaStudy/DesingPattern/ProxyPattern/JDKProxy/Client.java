package com.hjy.LearnStudy.JavaStudy.DesingPattern.ProxyPattern.JDKProxy;

import java.lang.reflect.Proxy;

/**
 * @author huangjunyan
 * @date 2019-07-02 11:38
 */
public class Client {
    public static void main(String[] args) {
        Message realMessage = new RealMessage();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(realMessage);

        Message proxyClass =(Message) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Message.class},myInvocationHandler);

        System.out.println(proxyClass.sendNumber());
        proxyClass.sendMessage();
    }
}
