package com.hjy.LearnStudy.JavaStudy.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author huangjunyan
 * @date 2019-08-19 11:53
 */
public class CountDownLatchStudy {
     
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        try {
            Thread.sleep(1000);
            int threadCount = (int) latch.getCount();
            System.out.println("等待" + threadCount + "个线程执行完毕...");
            latch.await();
            System.out.println(threadCount + "个线程已经执行结束");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
