package com.pengo.date.zone;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author pengo
 * @description:
 * @date 2021/12/30 15:49
 */
public class ZoneDemo {
    public static void main(String[] args) {
        flyTime();
    }

    public static void flyTime() {
        LocalDateTime departureAtBeijing = LocalDateTime.of(2019, 9, 15, 13, 0, 0);
        int hours = 13;
        int minutes = 20;
        LocalDateTime arrivalAtNewYork = calculateArrivalAtNY(departureAtBeijing, hours, minutes);
        System.out.println(departureAtBeijing + " -> " + arrivalAtNewYork);
        // test:
        if (!LocalDateTime.of(2019, 10, 15, 14, 20, 0)
                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 10, 15, 13, 0, 0), 13, 20))) {
            System.err.println("测试失败!");
        } else if (!LocalDateTime.of(2019, 11, 15, 13, 20, 0)
                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 11, 15, 13, 0, 0), 13, 20))) {
            System.err.println("测试失败!");
        }
    }

    static LocalDateTime calculateArrivalAtNY(LocalDateTime bj, int h, int m) {
        ZonedDateTime z1 = bj.atZone(ZoneId.of("Asia/Shanghai"));
        z1 = z1.plusHours(h);
        z1 = z1.plusMinutes(m);
        z1 = z1.withZoneSameInstant(ZoneId.of("America/New_York"));
        return z1.toLocalDateTime();
    }

    public static void test2() {
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault());
        ZonedDateTime zonedDateTime1 = zonedDateTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime1);
    }

    public static void test1() {
        ZonedDateTime zbj = ZonedDateTime.now();
        ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(zbj);
        System.out.println(zny);
    }
}
