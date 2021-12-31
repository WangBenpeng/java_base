package com.pengo.junit;

/**
 * @author pengo
 * @description:
 * @date 2021/12/31 09:06
 */
public class TestDemo {
    public static long fact(long n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        long r = 1;
        for (long i = 1; i < n; i++) {
            r += r * i;
        }
        return r;
    }
}
