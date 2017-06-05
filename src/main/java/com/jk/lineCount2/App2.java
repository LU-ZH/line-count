package com.jk.lineCount2;

import java.io.File;

/**
 * Created by dell on 2017/6/5.
 */
public class App2 {

    public static void main(String[] args) {
        Task task = new Task(new File("F:\\iWorkSpace\\lineCount"));
        TaskQueue.addToTail(task);

        int threadCount = 5;
        for (int i = 0; i < threadCount; i++) {
            new Worker().start();
        }

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int count = Task.getCount();
        System.out.println("总行数："+count);
    }
}
