package com.hjy.LearnStudy.JavaStudy.DesingPattern.ProxyPattern.CGLibProxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author huangjunyan
 * @date 2019-07-02 16:55
 */
public class CglibProxy implements MethodInterceptor {
    private Object target;

    public CglibProxy(Object target) {
        this.target = target;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before invocation");
        Object result = method.invoke(target,objects);
        System.out.println("after invocation");
        return result;
    }

    public static Object getProxy(Object target) {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(target.getClass());

        enhancer.setCallback(new CglibProxy(target));

        return enhancer.create();
    }
}
