package com.pengo.design.proxy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Queue;

/**
 * @author pengo
 * @description:
 * @date 2022/2/24 13:20
 */
public class PooledConnectionProxy extends AbstractConnectionProxy{
    Connection target;
    Queue<PooledConnectionProxy> idleQueue;

    public PooledConnectionProxy(Connection target, Queue<PooledConnectionProxy> idleQueue) {
        this.target = target;
        this.idleQueue = idleQueue;
    }

    @Override
    public void close() throws SQLException {
        System.out.println("Fake close and released to idle queue for future reuse: " + target);
        idleQueue.offer(this);
    }

    @Override
    protected Connection getRealConnection() {
        return target;
    }
}
