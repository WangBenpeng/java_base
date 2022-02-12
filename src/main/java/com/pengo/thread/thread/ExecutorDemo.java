package com.pengo.thread.thread;

import java.time.LocalTime;
import java.util.concurrent.*;

/**
 * @author pengo
 * @description:
 * @date 2022/2/11 14:18
 */
public class ExecutorDemo {
    public static void main(String[] args) throws Exception{
//        ExecutorService es = Executors.newFixedThreadPool(4);
//        ExecutorService es = new ThreadPoolExecutor(4, 6, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        ScheduledExecutorService ses = new ScheduledThreadPoolExecutor(4);
        for (int i = 0; i < 6; i++) {
//            es.submit(new Task("" + i));
            ses.scheduleAtFixedRate(new Task("" + i), 0, 1, TimeUnit.SECONDS);
        }
        Thread.sleep(15000L);
        ses.shutdown();
    }
}

class Task implements Runnable {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(LocalTime.now()+" start task " + Thread.currentThread().getName());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalTime.now() + " end task " + Thread.currentThread().getName());
    }
}
