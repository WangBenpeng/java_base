package com.pengo.thread.thread;

/**
 * @author pengo
 * @description:
 * @date 2022/2/10 15:50
 */
public class DeadLockDemo {
    public static void main(String[] args) {

    }

    static void testDead() {
        Counter3 counter3 = new Counter3();
        Thread t1 = new Thread(() -> {
            counter3.add(-1);
        });
        Thread t2 = new Thread(() -> {
            counter3.dec(1);
        });
        t1.start();
        t2.start();
        System.out.println(counter3.get());
    }

    static void test1() {
        Counter3 counter3 = new Counter3();
        counter3.add(-1);
        System.out.println(counter3.get());
    }
}

class Counter3{
    public final Object lock1 = new Object();
    public final Object lock2 = new Object();
    private int num = 0;

    public void add(int m) {
        synchronized (lock1) {
            System.out.println("get lock1");
            if (m < 0) {
                synchronized (lock2) {
                    System.out.println("get lock2");
                    dec(-m);
                }
            } else {
                num += 1;
            }
        }
    }

    public synchronized void dec(int n) {
        synchronized (lock2) {
            System.out.println("dec get lock2");
            synchronized (lock1) {
                System.out.println("dec get lock1");
                num -= n;
            }

        }
    }

    public int get() {
        return this.num;
    }
}
