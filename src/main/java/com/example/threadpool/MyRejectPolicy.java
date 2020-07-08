package com.example.threadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author sunpeng93
 * @description 自定义拒绝策略
 * @date 2019/12/24
 */
public class MyRejectPolicy implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("任务" + r.toString() + "被拒绝");
        if(!executor.isShutdown()){
            executor.getQueue().poll();
            executor.execute(r);
            System.out.println("任务" + r.toString() + "又被"+Thread.currentThread().getName()+"执行了");
        }
    }
}
