package com.hjy.LearnStudy.JavaStudy.ThreadLocal;


import java.util.Date;

/**
 * @author huangjunyan
 * @program test
 * @description ThreadLocalStudy
 * @date 2019-08-19 23:44
 */
public class ThreadLocalStudy {
    public static ThreadLocal<String> t1 = new ThreadLocal<>();

    public static void main(String[] args) {
//        if (t1.get() == null) {
//            System.out.println("set value for ThreadLocal");
//            t1.set("ha");
//        }
//        System.out.println(t1.get());

        for (int i = 0; i < 10; i++) {
            System.out.println(ThreadLocalTool.threadLocalTool.initialValue());
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new SonThread().start();
    }

    static class ThreadLocalTool extends ThreadLocal {
        public static ThreadLocalTool threadLocalTool = new ThreadLocalTool();

        @Override
        protected Object initialValue() {
            return new Date().getTime();
        }
    }

    public static class SonThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("In SonThread : " + ThreadLocalTool.threadLocalTool.initialValue());
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
