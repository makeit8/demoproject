package com.example.threadpool;

/**
 * @author sunpeng93
 * @description 工作任务类
 * @date 2019/12/24
 */
public class MyTask implements Runnable {
    private int taskId;
    private String taskName;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public MyTask(){}
    public MyTask(int taskId,String taskName){
        this.taskId = taskId;
        this.taskName = taskName;
    }
    @Override
    public void run() {
//        System.out.println(Thread.currentThread().getName() + "任务信息："+taskId+taskName);

        try {
            Thread.sleep(5000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("打断异常"+e.toString());
        }
    }
}
