package com.hjy.LearnStudy.JavaStudy.IOStudy.BIO.ThreadPoolBIO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-08-21 12:07
 */
public class BIOServerHandlerPool {
    private ExecutorService executorService;

    public BIOServerHandlerPool (int maxPoolSize, int queueSize) {
        executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), maxPoolSize,
                120L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(queueSize));
    }

    public void execute(Runnable task) {
        this.executorService.execute(task);
    }
}
