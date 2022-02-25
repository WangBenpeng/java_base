package com.pengo.design.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengo
 * @description:
 * @date 2022/2/24 14:06
 */
public class HandlerChain {
    private List<Handler> list = new ArrayList<>();

    public void addHandler(Handler handler) {
        this.list.add(handler);
    }

    public boolean process(Request request) {
        for (Handler handler : list) {
            Boolean process = handler.process(request);
            if (process != null) {
                System.out.println(request.toString() + " " + (process ? "Approved by " : "Denied by ") + handler.getClass().getSimpleName());
                return process;
            }
        }
        throw new RuntimeException("Could not handle request: " + request);
    }
}
