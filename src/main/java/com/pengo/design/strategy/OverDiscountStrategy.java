package com.pengo.design.strategy;

import java.math.BigDecimal;

/**
 * @author pengo
 * @description:
 * @date 2022/2/25 13:24
 */
public class OverDiscountStrategy implements DiscountStrategy{
    @Override
    public BigDecimal getDiscount(BigDecimal total) {
        return total.compareTo(new BigDecimal("100")) > 0 ? new BigDecimal("20") : BigDecimal.ZERO;
    }
}
