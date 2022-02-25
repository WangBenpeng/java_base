package com.pengo.design.chain;

import java.math.BigDecimal;

/**
 * @author pengo
 * @description:
 * @date 2022/2/24 14:02
 */
public class Request {
    private String name;
    private BigDecimal amount;

    public Request(String name, BigDecimal amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
