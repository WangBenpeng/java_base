package com.pengo.date;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author pengo
 * @description:
 * @date 2021/12/30 16:44
 */
public class DateDemo {
    public static void main(String[] args) {
        test1(1640016000000L, Locale.CHINA, ZoneId.systemDefault().getId());
        test1(1640016000000L, Locale.US, ZoneId.of("America/New_York").getId());
    }

    public static void test1(long milli, Locale locale, String zoneId) {
        Instant instant = Instant.ofEpochMilli(milli);
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT);
        System.out.println(f.withLocale(locale).format(ZonedDateTime.ofInstant(instant, ZoneId.of(zoneId))));
    }

    public static void new2old() {
        ZonedDateTime now = ZonedDateTime.now();
        long l = now.toEpochSecond() * 1000;

        Date date = new Date(l);
        System.out.println(date);

        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.setTimeZone(TimeZone.getTimeZone(now.getZone().getId()));
        instance.setTimeInMillis(l);
        System.out.println(instance.getTime());
    }

    public static void old2new() {
        Instant instant = new Date().toInstant();
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);

        Calendar calendar = Calendar.getInstance();
        Instant instant1 = calendar.toInstant();
        ZonedDateTime zonedDateTime1 = instant1.atZone(calendar.getTimeZone().toZoneId());
        System.out.println(zonedDateTime1);
    }
}
