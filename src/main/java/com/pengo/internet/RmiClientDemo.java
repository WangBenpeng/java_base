package com.pengo.internet;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;

/**
 * @author pengo
 * @description:
 * @date 2022/2/16 16:38
 */
public class RmiClientDemo {
    public static void main(String[] args) throws Exception{
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        WorldClock worldClock = (WorldClock) registry.lookup("WorldClock");
        LocalDateTime localDateTime = worldClock.getLocalDateTime("Asia/Shanghai");
        System.out.println(localDateTime);
    }
}
