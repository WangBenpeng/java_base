package com.pengo.date.format;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author pengo
 * @description:
 * @date 2021/12/30 16:28
 */
public class FormatDemo {
    public static void main(String[] args) {
        test2();
    }

    public static void test2() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ISO_DATE.format(now));
        System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(now));
    }

    public static void test1() {
        ZonedDateTime z1 = ZonedDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        System.out.println(dtf.format(z1));

        DateTimeFormatter zhFormat = DateTimeFormatter.ofPattern("yyyy MMM dd EE HH:mm", Locale.CHINA);
        System.out.println(zhFormat.format(z1));

        DateTimeFormatter usFormat = DateTimeFormatter.ofPattern("E, MMMM/dd/yyyy HH:mm", Locale.US);
        System.out.println(usFormat.format(z1));

    }
}
