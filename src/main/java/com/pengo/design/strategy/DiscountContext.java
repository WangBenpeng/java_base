package com.pengo.design.strategy;

import java.math.BigDecimal;

/**
 * @author pengo
 * @description:
 * @date 2022/2/25 13:25
 */
public class DiscountContext {
    private DiscountStrategy strategy = new UserDiscountStrategy();

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public BigDecimal calculatePrice(BigDecimal total) {
        return total.subtract(strategy.getDiscount(total)).setScale(2);
    }

}
