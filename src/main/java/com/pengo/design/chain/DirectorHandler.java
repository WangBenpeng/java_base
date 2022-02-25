package com.pengo.design.chain;

import java.math.BigDecimal;

/**
 * @author pengo
 * @description:
 * @date 2022/2/24 14:05
 */
public class DirectorHandler implements Handler{
    @Override
    public Boolean process(Request request) {
        System.out.println(this.getClass().getSimpleName() + " begin process..." + request.getName() + ":" + request.getAmount());
        if (request.getAmount().compareTo(new BigDecimal(10000)) > 0) {
            return null;
        }
        return true;
    }
}
