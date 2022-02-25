package com.pengo.design.facotry;

import java.time.LocalDate;

public interface NumberFactory {
    Number parse(String s);

    LocalDate parse2date(int n);

    static NumberFactory getFactory() {
        return impl;
    }

    static NumberFactoryImpl impl = new NumberFactoryImpl();
}
