package com.example.test;

import com.example.threadpool.MyTask;
import com.example.util.ThreadPoolUtil;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author sunpeng93
 * @description 任务类测试
 * @date 2019/12/24
 */
public class MyTaskTest {

    public static void main(String[] args) {
        ThreadPoolExecutor executorService = ThreadPoolUtil.getExecutor();
        executorService.execute(new MyTask(1, "任务1"));
        System.out.println("当前执行完成任务数"+executorService.getCompletedTaskCount()+"CorePoolSize存活线程数"+executorService.getCorePoolSize());
        executorService.execute(new MyTask(2, "任务2"));
        executorService.execute(new MyTask(3, "任务3"));
        executorService.execute(new MyTask(4, "任务4"));
        executorService.execute(new MyTask(5, "任务5"));
        System.out.println("当前执行完成任务数"+executorService.getCompletedTaskCount());
        executorService.execute(new MyTask(6, "任务6"));
        executorService.execute(new MyTask(7, "任务7"));
        executorService.execute(new MyTask(8, "任务8"));
        executorService.execute(new MyTask(9, "任务9"));
        executorService.execute(new MyTask(10, "任务10"));


        System.out.println("需要继续执行的任务列表：");
        List<Runnable> runnableList = ThreadPoolUtil.rejectTask;
        System.out.println("被拒绝的长度"+runnableList.size());
        runnableList.forEach(System.out::println);
        for(;;){
            if(executorService.getCompletedTaskCount()>=runnableList.size()){
                if(runnableList.size()>0){
                    runnableList.forEach(runnable -> {
                        MyTask myTask = (MyTask) runnable;
                        System.out.println(myTask.getTaskName()+myTask.getTaskId()+"jjjjjjjjjjjjjj");
                        executorService.execute(myTask);
                    });
                }
                executorService.shutdown();
                return;
            }
        }
    }
}
