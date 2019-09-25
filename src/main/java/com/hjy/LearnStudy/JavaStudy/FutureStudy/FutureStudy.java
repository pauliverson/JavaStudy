package com.hjy.LearnStudy.JavaStudy.FutureStudy;

import java.util.concurrent.*;

/**
 * @author huangjunyan
 * @date 2019-08-19 11:24
 */
public class FutureStudy {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Task task = new Task();
//        Future result = executorService.submit(task);
//        executorService.shutdown();
        FutureTask<Integer> futureTask = new FutureTask(task);
        executorService.submit(futureTask);
        executorService.shutdown();

        System.out.println("主线程在执行任务");

        try {
//            futureTask.cancel(false);
            System.out.println("task result: " + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("所有任务都已经执行完毕");
    }
}

class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程正在计算");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 10000; i++) {
            sum += i;
        }
        return sum;
    }
}
