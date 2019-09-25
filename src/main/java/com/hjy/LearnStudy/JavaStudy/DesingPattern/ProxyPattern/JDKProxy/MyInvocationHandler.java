package com.hjy.LearnStudy.JavaStudy.DesingPattern.ProxyPattern.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author huangjunyan
 * @date 2019-07-02 11:33
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("准备调用方法");
        Object returnVal = method.invoke(target,args);
        System.out.println("调用成功");
        return returnVal;
    }
}
