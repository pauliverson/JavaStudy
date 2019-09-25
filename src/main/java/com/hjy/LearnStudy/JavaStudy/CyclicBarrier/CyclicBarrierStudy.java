package com.hjy.LearnStudy.JavaStudy.CyclicBarrier;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author huangjunyan
 * @date 2019-08-19 12:36
 */
public class CyclicBarrierStudy {
    final static int N = 4;

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(N);
        for (int i = 0; i < N; i++) {
            new Writer(cyclicBarrier).start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("重用Barrier");
        for (int i = 0; i < N; i++) {
            new Writer(cyclicBarrier).start();
        }

    }

    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
            try {
                Thread.sleep(5000);      //以睡眠来模拟写入数据操作
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");

                //await方法等待了指定的时间发现最后一个线程还没到barrier，就抛出异常并执行后面的任务
                //cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);
                cyclicBarrier.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }
}
