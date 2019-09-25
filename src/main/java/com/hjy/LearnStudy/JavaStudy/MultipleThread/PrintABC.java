package com.hjy.LearnStudy.JavaStudy.MultipleThread;

import java.util.concurrent.Semaphore;

/**
 * @author huangjunyan
 * @date 2019-07-03 10:35
 */
public class PrintABC {
    private static Semaphore A = new Semaphore(1);
    private static Semaphore B = new Semaphore(0);
    private static Semaphore C = new Semaphore(0);
    static class TA extends Thread {

        @Override
        public void run() {
            for(int i = 0;i < 10;i++) {
                try {
                    A.acquire();
                    System.out.println(i+1);
                    System.out.println("A");
                    B.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    static class TB extends Thread {

        @Override
        public void run() {
            for(int i = 0;i < 10;i++) {
                try {
                    B.acquire();
                    System.out.println("B");
                    C.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    static class TC extends Thread {

        @Override
        public void run() {
            for(int i = 0;i < 10;i++) {
                try {
                    C.acquire();
                    System.out.println("C");
                    A.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    public static void main(String[] args) {
        new TA().start();
        new TB().start();
        new TC().start();
    }
}
