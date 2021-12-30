package com.pengo.date.instant;

import java.time.Instant;
import java.time.ZoneId;

/**
 * @author pengo
 * @description:
 * @date 2021/12/30 16:36
 */
public class InstantDemo {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(now.getEpochSecond());
        System.out.println(now.toEpochMilli());
        System.out.println(now.atZone(ZoneId.systemDefault()));
        System.out.println(now.atZone(ZoneId.of("America/New_York")));
    }
}
