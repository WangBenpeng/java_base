package com.pengo.date.localdatetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

/**
 * @author pengo
 * @description:
 * @date 2021/12/30 14:20
 */
public class LocalDateTimeDemo {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        LocalDateTime start = LocalDateTime.of(2021, 1, 1, 12, 0, 0);
        LocalDateTime end = LocalDateTime.of(2021, 1, 2, 12, 0, 0);
        Duration between = Duration.between(start, end);
        System.out.println(between);
        LocalDate s1 = LocalDate.now();
        LocalDate s2 = LocalDate.of(2021, 12, 21);
        System.out.println(Period.between(s1, s2));
        System.out.println("------");
        System.out.println(start.isBefore(end));
    }
}
