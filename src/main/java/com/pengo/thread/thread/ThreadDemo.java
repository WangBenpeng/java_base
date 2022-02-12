package com.pengo.thread.thread;

import java.time.LocalDateTime;

/**
 * @author pengo
 * @description:
 * @date 2022/1/4 09:57
 */
public class ThreadDemo {
    public static void main(String[] args) throws Exception{
        test2();
    }

    public static void test2() {
        /** * 守护线程Demo */
        //创建线程
        Thread daemonThread = new Thread("Daemon") {
            @Override
            public void run() {
                super.run();
                //循环执行5次(休眠一秒，输出一句话)
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("守护线程->" + Thread.currentThread().getName() + "正在执行");
                }
            }
        };
        //设置为守护线程，必须在线程启动start()方法之前设置，否则会抛出IllegalThreadStateException异常
        daemonThread.setDaemon(true);
        //启动守护线程
        daemonThread.start();
        //这里是主线程逻辑
        // 循环执行3次(休眠一秒，输出一句话)
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("普通线程->" + Thread.currentThread().getName() + "正在执行");
        }
    }

    public static void testDaemon() throws Exception{
        Thread t = new TimeThread();
        t.setDaemon(true);
        t.start();
        Thread.sleep(10000);
    }

    public static void testVolatile() throws Exception{
        HelloThread2 t = new HelloThread2();
        t.start();
        Thread.sleep(1);
        t.running = false;
    }

    public static void testInterrupt2() throws Exception {
        Thread t = new MyThread2();
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        t.join();
        System.out.println("end");
    }

    public static void testInterrupt() throws Exception{
        Thread t = new MyThread();
        t.start();
        Thread.sleep(10);
        t.interrupt();
        t.join();
        System.out.println("end");
    }

    public static void  test1() throws Exception{
        System.out.println("main start");
        Thread thread = new Thread(() -> {
            System.out.println("thread start");
            System.out.println("thread end");
        });
        thread.start();
        thread.join();
        System.out.println("main end");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello");
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        Thread helloThread = new HelloThread();
        helloThread.start();
        try {
            helloThread.join();
        } catch (InterruptedException e) {
            System.out.println("interrupted!!!");
        }
        helloThread.interrupt();
    }
}

class HelloThread extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

class HelloThread2 extends Thread {
    public volatile boolean running = true;

    @Override
    public void run() {
        int n = 0;
        while (running) {
            n++;
            System.out.println(n + " hello");
        }
    }
}

class TimeThread extends Thread {
    @Override
    public void run() {
        while (true) {
            LocalDateTime now = LocalDateTime.now();
            System.out.println(now);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
