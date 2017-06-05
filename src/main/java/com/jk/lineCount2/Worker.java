package com.jk.lineCount2;

/**
 * Created by dell on 2017/6/5.
 */
public class Worker extends Thread {

    /**
     * 工作线程
     * 不断的从任务队列中取出一个任务并执行
     */
    @Override
    public void run() {
        while(true){
            Task task = TaskQueue.removeHead();
            if (task != null)
                task.execute();
            else {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
