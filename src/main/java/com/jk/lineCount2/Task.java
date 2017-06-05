package com.jk.lineCount2;

import com.jk.FileUtil;

import java.io.File;

/**
 * Created by dell on 2017/6/5.
 */
public class Task {

    private static int count = 0;

    private File dir;// 待统计文件夹

    public static int getCount() {
        return count;
    }

    public Task(File dir) {
        this.dir = dir;
    }

    /**
     * 执行任务
     * <p/>
     * 遍历此文件夹下所有文件和子文件夹
     * 1.如果是文件就统计行数
     * 2.如果是文件夹就作文新的队列放到人物对列尾
     */
    public void execute() {
        System.out.println(Thread.currentThread() + "------------->正在办理任务:" + dir.getPath());
        for (File file : dir.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".java")) {
                synchronized (Task.class){//注意同步问题
                    count += FileUtil.getLineCount(file);
                }
            } else if (file.isDirectory()) {
                Task task = new Task(file);
                TaskQueue.addToTail(task);
            }
        }
    }
}
