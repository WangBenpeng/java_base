package com.pengo.design.chain;

import java.math.BigDecimal;

/**
 * @author pengo
 * @description:
 * @date 2022/2/24 14:01
 */
public class ChainDemo {
    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new ManagerHandler());
        chain.addHandler(new DirectorHandler());
        chain.addHandler(new CEOHandler());
        chain.process(new Request("bob", new BigDecimal(999)));
        chain.process(new Request("alice", new BigDecimal(123)));
        chain.process(new Request("joyce", new BigDecimal(1234)));
        chain.process(new Request("karl", new BigDecimal(12345)));
    }
}
