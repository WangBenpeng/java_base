package com.pengo.design.adapter;

import java.util.concurrent.Callable;

/**
 * @author pengo
 * @description:
 * @date 2022/2/23 17:42
 */
public class AdapterDemo {
    public static void main(String[] args) {
        Task task = new Task(123456);
        Thread t = new Thread(new RunnableAdapter(task));
        t.start();
    }
}

class RunnableAdapter implements Runnable {
    private Task task;

    public RunnableAdapter(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        try {
            task.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Task implements Callable<Long> {
    private int num;

    public Task(int num) {
        this.num = num;
    }

    @Override
    public Long call() throws Exception {
        long result = 0;
        for (int i = 0; i < this.num; i++) {
            result = result + i;
        }
        System.out.println("result:"+result);
        return result;
    }
}
