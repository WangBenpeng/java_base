package com.pengo.date.calend;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author pengo
 * @description:
 * @date 2021/12/30 13:28
 */
public class CalenderDemo {
    public static void main(String[] args) {
        test7();
    }

    public static void test7() {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(2000, Calendar.JANUARY, 1, 1, 1, 1);
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        calendar.add(Calendar.HOUR_OF_DAY, 2);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));
    }

    public static void test6() {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(2020, Calendar.DECEMBER, 30, 12, 12, 12);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        System.out.println(simpleDateFormat.format(calendar.getTime()));
    }

    public static void test5() {
        TimeZone tzDefault = TimeZone.getDefault();
        TimeZone tz1 = TimeZone.getTimeZone("GMT+09:00");
        TimeZone tz2 = TimeZone.getTimeZone("America/New_York");
        System.out.println(tzDefault.getID());
        System.out.println(tz1.getID());
        System.out.println(tz2.getID());

    }

    public static void test4() {
        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH) + 1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));
        System.out.println(calendar.get(Calendar.MILLISECOND));

        calendar.clear();
        calendar.set(Calendar.YEAR, 2000);
        calendar.set(Calendar.MONTH, 7);
        calendar.set(Calendar.DAY_OF_MONTH, 8);
        calendar.set(Calendar.HOUR_OF_DAY, 20);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));

    }

    public static void test3() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        System.out.println(format);
    }

    public static void test2() {
        Date date = new Date();
        System.out.println(date.getYear() + 1900);
        System.out.println(date.getMonth() + 1);
        System.out.println(date.getDate());
        System.out.println(date.toString());
        System.out.println(date.toGMTString());
        System.out.println(date.toLocaleString());
    }

    public static void test1() {
        int n = 123400;
        System.out.println(n);
        System.out.println(Integer.toHexString(n));
        System.out.println(NumberFormat.getCurrencyInstance(Locale.CHINA).format(n));
    }
}
