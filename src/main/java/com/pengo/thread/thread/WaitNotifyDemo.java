package com.pengo.thread.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author pengo
 * @description:
 * @date 2022/2/11 11:15
 */
public class WaitNotifyDemo {
    public static void main(String[] args) throws Exception{
        test1();
    }
    static void test1() throws Exception{
        TaskQueue taskQueue = new TaskQueue();
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread t1 = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "-" + taskQueue.getTask());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            t1.start();
            list.add(t1);
        }
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                taskQueue.addTask(i + "");
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
        t.join();
        for (Thread thread : list) {
            thread.join();
        }
        t.interrupt();
    }
}

class TaskQueue{
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        queue.add(s);
        this.notifyAll();
    }

    public synchronized String getTask() throws Exception{
        while (queue.isEmpty()) {
            this.wait();
        }
        return queue.remove();
    }
}
