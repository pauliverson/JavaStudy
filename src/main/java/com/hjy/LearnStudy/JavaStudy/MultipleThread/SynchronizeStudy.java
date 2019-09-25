package com.hjy.LearnStudy.JavaStudy.MultipleThread;



/**
 * @author huangjunyan
 * @date 2019-07-02 18:14
 */
public class SynchronizeStudy implements Runnable{
//    volatile static int i = 0;
    volatile static Integer count = 1;

    public void addCount() {
        synchronized (count) {
            System.out.println(Thread.currentThread().getName()+this.count);
            count++;
        }
    }

//    public synchronized void increase() {
//        notifyAll();
//        i++;
//        System.out.println(Thread.currentThread().getName()+this.i);
//        try {
//            if(i == 100) {
//                notifyAll();
//            }
//            else {
//                wait();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void run() {
        int i = 0;
        while(i < 100) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            addCount();
            i++;
        }

    }

    public static void main(String[] args) throws InterruptedException{

        SynchronizeStudy synchronizeStudy = new SynchronizeStudy();
        Thread t1 = new Thread(synchronizeStudy,"A");
        Thread t2 = new Thread(synchronizeStudy,"B");
        Thread t3 = new Thread(synchronizeStudy,"C");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("--------" + count);

//        C c = synchronizeStudy.new C();

    }


}
