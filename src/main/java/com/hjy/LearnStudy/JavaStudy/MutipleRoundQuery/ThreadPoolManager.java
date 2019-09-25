package com.hjy.LearnStudy.JavaStudy.MutipleRoundQuery;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangjunyan
 * @date 2019-07-04 14:37
 */
public class ThreadPoolManager {

    private int poolSize = 10;
    private final static int MIN_POOL_SIZE = 1;
    private final static int MAX_POOL_SIZE = 100;

    private ExecutorService threadPool;

    /** 请求队列 */
    private LinkedList<ThreadPoolTask> asyncTasks;
    /** 轮询线程 */
    private Thread poolThread;
    /** 轮询时间 */
    private static final int SLEEP_TIME = 5;

    public ThreadPoolManager(int poolSize) {
        if(poolSize < MIN_POOL_SIZE) {
            poolSize = MIN_POOL_SIZE;
        }
        if(poolSize > MAX_POOL_SIZE) {
            poolSize = MAX_POOL_SIZE;
        }
        this.poolSize = poolSize;
        threadPool = Executors.newFixedThreadPool(this.poolSize);
        asyncTasks = new LinkedList<ThreadPoolTask>();
    }

    public void addAsyncTask(ThreadPoolTask task) {
        synchronized (asyncTasks) {
            // Log.i(TAG, "add task: " + task.getURL());
            asyncTasks.addLast(task);
        }
    }

    private ThreadPoolTask getAsyncTask() {
        synchronized (asyncTasks) {
            if (asyncTasks.size() > 0) {
                ThreadPoolTask task = asyncTasks.removeFirst();
                // Log.i(TAG, "remove task: " + task.getURL());
                return task;
            }
        }
        return null;
    }
    public void start() {
        if(poolThread == null) {
            poolThread = new Thread(new PoolRunnable());
            poolThread.start();
        }
    }

    public void stop() {
        poolThread.interrupt();
        poolThread = null;
    }

    private class PoolRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("start round query");
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    ThreadPoolTask task = getAsyncTask();
                    if (task == null) {
                        try {
                            Thread.sleep(SLEEP_TIME);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        continue;
                    }
                    threadPool.execute(task);
                }
            } finally {
                threadPool.shutdown();
            }
            System.out.println("end round query");
        }
    }
}
