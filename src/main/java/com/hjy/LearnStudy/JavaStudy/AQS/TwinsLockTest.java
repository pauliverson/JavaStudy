package com.hjy.LearnStudy.JavaStudy.AQS;

import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-09-06 16:27
 */
public class TwinsLockTest {
    @Test
    public void test() {
        final Lock lock = new TwinsLock();

        class Worker extends Thread {
            public void run () {
                while (true) {
                    lock.lock();
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                }
            }
        }

        for (int i = 0; i < 10; i++) {
            Worker worker = new Worker();
            worker.isDaemon();
            worker.start();
        }

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
