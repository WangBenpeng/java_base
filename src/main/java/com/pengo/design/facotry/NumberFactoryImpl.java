package com.pengo.design.facotry;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author pengo
 * @description:
 * @date 2022/2/23 15:03
 */
public class NumberFactoryImpl implements NumberFactory{
    @Override
    public Number parse(String s) {
        return new BigDecimal(s);
    }

    @Override
    public LocalDate parse2date(int n) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.parse(String.valueOf(n), formatter);
    }
}
