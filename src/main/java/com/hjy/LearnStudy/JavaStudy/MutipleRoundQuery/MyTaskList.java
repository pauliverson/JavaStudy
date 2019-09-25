package com.hjy.LearnStudy.JavaStudy.MutipleRoundQuery;

import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author huangjunyan
 * @date 2019-07-04 15:41
 */
public class MyTaskList {
    private ThreadPoolManager threadPoolManager;

    private Timer timer;

    public MyTaskList(ThreadPoolManager threadPoolManager) {
        this.threadPoolManager = threadPoolManager;
        timer = new Timer();
    }

    public void addTask(ThreadPoolTask threadPoolTask) {
        if(threadPoolTask != null) {
            threadPoolManager.addAsyncTask(threadPoolTask);
        }
    }

    public void addTask(TimerTask timerTask,long delay) {
        try {
            Class<?> clazz = TimerTask.class;
            Field field = clazz.getDeclaredField("state");
            field.setAccessible(true);
            field.set(timerTask, 0);
        } catch (Exception e) {

        }
        timer.schedule(timerTask,delay);
    }
}
