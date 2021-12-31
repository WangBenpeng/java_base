package com.pengo.junit;

/**
 * @author pengo
 * @description:
 * @date 2021/12/31 09:30
 */
public class Calculator {
    private long n = 0;

    public long add(long x) {
        n += x;
        return n;
    }

    public long sub(long x) {
        n -= x;
        return n;
    }
}
