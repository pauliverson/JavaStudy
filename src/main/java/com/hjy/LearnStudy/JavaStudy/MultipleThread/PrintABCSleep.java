package com.hjy.LearnStudy.JavaStudy.MultipleThread;

/**
 * @author huangjunyan
 * @date 2019-07-03 10:57
 */
public class PrintABCSleep extends Thread {

    private static int currentCount = 0;
    private static int myCount = 0;

    public PrintABCSleep(String name) {
        this.setName(name);
    }

    @Override
    public void run() {

        while (currentCount < 30) {
            switch (currentCount % 3) {
                case 0:
                    myCount++;
                    if ("A".equals(getName())) {
                        System.out.println(currentCount/3 + 1);
                        printAndIncrease();
                    }
                    break;
                case 1:
                    myCount++;
                    if ("B".equals(getName())) {
                        printAndIncrease();
                    }
                    break;
                case 2:
                    myCount++;
                    if ("C".equals(getName())) {
                        printAndIncrease();
                    }
                    break;
            }
        }

    }
    public void printAndIncrease() {
        System.out.println(getName());
        currentCount++;
    }

    public static void main(String[] args) {
        new PrintABCSleep("A").start();
        new PrintABCSleep("B").start();
        new PrintABCSleep("C").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(myCount);
    }

}
