package com.pengo.internet;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author pengo
 * @description:
 * @date 2022/2/16 16:23
 */
public class RmiServerDemo {
    public static void main(String[] args) throws Exception{
        System.out.println("create World clock remote service...");
        WorldClock worldClock = new WorldClockService();
        WorldClock skeleton = (WorldClock) UnicastRemoteObject.exportObject(worldClock, 0);
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("WorldClock", skeleton);
    }


}
