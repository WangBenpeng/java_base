package com.pengo.internet;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author pengo
 * @description:
 * @date 2022/2/16 16:26
 */
public class WorldClockService implements WorldClock{
    @Override
    public LocalDateTime getLocalDateTime(String zoneId) throws RemoteException {
        return LocalDateTime.now(ZoneId.of(zoneId)).withNano(0);
    }
}
