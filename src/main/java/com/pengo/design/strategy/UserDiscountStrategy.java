package com.pengo.design.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author pengo
 * @description:
 * @date 2022/2/25 13:23
 */
public class UserDiscountStrategy implements DiscountStrategy{
    @Override
    public BigDecimal getDiscount(BigDecimal total) {
        return total.multiply(new BigDecimal("0.1")).setScale(2, RoundingMode.DOWN);
    }
}
