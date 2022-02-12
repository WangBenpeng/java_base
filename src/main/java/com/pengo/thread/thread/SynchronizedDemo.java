package com.pengo.thread.thread;

/**
 * @author pengo
 * @description:
 * @date 2022/2/10 14:53
 */
public class SynchronizedDemo {
    public static void main(String[] args) throws Exception {
        test3();
    }

    static void test3() throws Exception{
        Counter2 counter2 = new Counter2();
        new Thread(new Runnable() {
            @Override
            public void run() {
                counter2.add();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                counter2.dec();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                counter2.dec();
            }
        }).start();
        Thread.sleep(1000);
        System.out.println(counter2.get());
    }

    static void test2() throws Exception{
        long now = System.currentTimeMillis();
        System.out.println(now);
        Thread[] threads = new Thread[]{new AddThread(), new DecThread(), new AddTeacherThread(), new DecTeacherThread()};
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(Counter.student);
        System.out.println(Counter.teacher);
        System.out.println("last--->" + (System.currentTimeMillis() - now));
    }

    static void add(int m) {
        synchronized (SynchronizedDemo.class) {
            if (m < 0) {
                throw new IllegalArgumentException();
            }
            System.out.println(m + 1);
        }
    }

    static void test1() throws Exception{
        Thread add = new AddThread();
        Thread dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.n);
    }
}

class Counter2{
    public int num = 0;

    public void add() {
        synchronized (this) {
            this.num += 1;
        }
    }

    public void dec() {
        synchronized (this) {
            this.num -= 1;
        }
    }

    public int get() {
        return this.num;
    }
}

class Counter{
    public static final Object lock = new Object();
    public static int n = 0;

    public static final Object studentLock = new Object();
    public static final Object teacherLock = new Object();
    public static int student = 0;
    public static int teacher = 0;
}

class AddThread extends Thread {
    @Override
    public void run() {
        synchronized (Counter.studentLock) {
            for (int i = 0; i < 10000; i++) {
                Counter.student += 1;
            }
        }
    }
}
class DecThread extends Thread {
    @Override
    public void run() {
        synchronized (Counter.studentLock) {
            for (int i = 0; i < 10000; i++) {
                Counter.student -= 1;
            }
        }
    }
}

class AddTeacherThread extends Thread {
    @Override
    public void run() {
        synchronized (Counter.teacherLock) {
            for (int i = 0; i < 10000; i++) {
                Counter.teacher += 1;
            }
        }
    }
}
class DecTeacherThread extends Thread {
    @Override
    public void run() {
        synchronized (Counter.teacherLock) {
            for (int i = 0; i < 10000; i++) {
                Counter.teacher -= 1;
            }
        }
    }
}
