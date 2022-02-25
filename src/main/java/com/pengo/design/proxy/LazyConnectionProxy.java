package com.pengo.design.proxy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.Supplier;

/**
 * @author pengo
 * @description:
 * @date 2022/2/24 12:07
 */
public class LazyConnectionProxy extends AbstractConnectionProxy{
    private Supplier<Connection> supplier;
    private Connection target = null;

    public LazyConnectionProxy(Supplier<Connection> supplier) {
        this.supplier = supplier;
    }

    @Override
    public void close() throws SQLException {
        if (target != null) {
            System.out.println("Close connection: " + target);
            super.close();
        }
    }

    @Override
    protected Connection getRealConnection() {
        if (target == null) {
            target = supplier.get();
        }
        return target;
    }
}
