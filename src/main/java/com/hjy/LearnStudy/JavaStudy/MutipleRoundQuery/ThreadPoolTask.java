package com.hjy.LearnStudy.JavaStudy.MutipleRoundQuery;

/**
 * @author huangjunyan
 * @date 2019-07-04 14:41
 */
public class ThreadPoolTask implements Runnable {

    private String tag;

    private Callback callback;

    public ThreadPoolTask(String tag, Callback callback) {
        this.tag = tag;
        this.callback = callback;
    }

    @Override
    public void run() {
        System.out.println(tag+" is running on "+Thread.currentThread());
        try {
            // 模拟耗时任务
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (callback != null)
            callback.onRetry();
    }

    public interface Callback {
        void onRetry();
    }
}
