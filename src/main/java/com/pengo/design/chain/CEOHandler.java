package com.pengo.design.chain;

/**
 * @author pengo
 * @description:
 * @date 2022/2/24 14:05
 */
public class CEOHandler implements Handler{

    @Override
    public Boolean process(Request request) {
        System.out.println(this.getClass().getSimpleName() + " begin process..." + request.getName() + ":" + request.getAmount());
        return true;
    }
}
