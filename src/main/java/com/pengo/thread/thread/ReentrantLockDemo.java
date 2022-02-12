package com.pengo.thread.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author pengo
 * @description:
 * @date 2022/2/11 11:28
 */
public class ReentrantLockDemo {
    public static void main(String[] args) throws Exception{
        Counter4 c = new Counter4();
        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 10000; i++) {
                    c.add();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 10000; i++) {
                    c.dec();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();
        t1.start();
        t2.join();
        t1.join();
        System.out.println(c.get());
    }
}

class Counter4 {
    private final Lock lock = new ReentrantLock();
    private int n = 0;

    public void add() throws InterruptedException {
//        lock.lock();
        if(lock.tryLock(1, TimeUnit.MILLISECONDS)) {
            try {
                n += 1;
            } finally {
                lock.unlock();
            }
        }
    }

    public void dec() throws InterruptedException {
        lock.lock();
        if (lock.tryLock(1, TimeUnit.MILLISECONDS)) {
            try {
                n -= 1;
            }finally {
                lock.unlock();
            }
        }
    }

    public int get() {
        return this.n;
    }
}