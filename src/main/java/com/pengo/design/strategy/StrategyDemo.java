package com.pengo.design.strategy;

import java.math.BigDecimal;

/**
 * @author pengo
 * @description:
 * @date 2022/2/25 11:29
 */
public class StrategyDemo {
    public static void main(String[] args) {
        DiscountContext context = new DiscountContext();
        BigDecimal pay = context.calculatePrice(new BigDecimal("105"));
        System.out.println(pay);
        context.setStrategy(new OverDiscountStrategy());
        pay = context.calculatePrice(new BigDecimal("105"));
        System.out.println(pay);
    }
}
