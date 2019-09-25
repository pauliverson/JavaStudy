package com.hjy.LearnStudy.JavaStudy.MultipleThread;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangjunyan
 * @date 2019-08-12 23:59
 */
public class TokenDemo {
    static RateLimiter rateLimiter = RateLimiter.create(100);

    public void doSomething() {
        if (rateLimiter.tryAcquire()) {
            System.out.println("正常处理");
        } else {
            System.out.println("处理失败");
        }
    }

    public static void main(String[] args) {
        ExecutorService fixPool = Executors.newFixedThreadPool(20);
        Random random = new Random(10);
        TokenDemo tokenDemo = new TokenDemo();
        for (int i = 0; i < 20; i++) {
            fixPool.submit(() -> {
                System.out.println("等待时间：" + rateLimiter.acquire());
            });
        }
        fixPool.shutdown();
    }

}
