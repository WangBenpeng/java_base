package com.pengo.thread.thread;

/**
 * @author pengo
 * @description:
 * @date 2022/1/4 09:57
 */
public class ThreadDemo {
    public static void main(String[] args) throws Exception{
        test1();
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
