package com.example.util;

import com.example.threadpool.MyRejectPolicy;
import com.example.threadpool.MyTask;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author sunpeng93
 * @description 线程池工具类
 * @date 2019/12/24
 */
public class ThreadPoolUtil {
    private static final int COREPOOLSIZE = Runtime.getRuntime().availableProcessors()*2;

    private static ThreadPoolExecutor executorService = null;
    private ThreadPoolUtil(){}

    public static volatile List<Runnable> rejectTask=new ArrayList<>();
    public static ThreadPoolExecutor getExecutor(){
        if (executorService == null){
            synchronized (ThreadPoolUtil.class){
                if(executorService == null){
                    System.out.println(COREPOOLSIZE);
                    ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("DiyThreadPool-%s").build();
                    executorService = new ThreadPoolExecutor(1,3,60l,
                            TimeUnit.SECONDS,new ArrayBlockingQueue<>(3),
                            threadFactory,
                            (r,executor)->{
                            //把拒绝的任务记录日志,然后空闲时间解析再重新执行
                            System.out.println("当前被拒绝任务为：" + r.toString());
                            rejectTask.add(r);}
                        );
                }
            }
        }
        return executorService;
    }
}
