package com.jk.lineCount2;

import java.util.LinkedList;

/**
 * Created by dell on 2017/6/5.
 */
public class TaskQueue {

    private static LinkedList<Task> queue = new LinkedList<Task>();

    public static synchronized void addToTail(Task task) {
        queue.addLast(task);
    }

    public static synchronized Task removeHead() {
        if (queue.size() > 0) {
            return queue.removeFirst();
        } else {
            return null;
        }
    }
}
