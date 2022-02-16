package com.pengo.internet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * @author pengo
 * @description:
 * @date 2022/2/14 14:48
 */
public class UdpServerDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(6666);
        for (; ; ) {
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            ds.receive(packet);
            String s = new String(packet.getData(), packet.getOffset(), packet.getLength(), StandardCharsets.UTF_8);
            System.out.println("server receive:" + s);
            byte[] data = "ACK".getBytes(StandardCharsets.UTF_8);
            packet.setData(data);
            ds.send(packet);
        }
    }
}
