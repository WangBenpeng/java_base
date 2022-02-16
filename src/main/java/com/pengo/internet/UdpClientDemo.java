package com.pengo.internet;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * @author pengo
 * @description:
 * @date 2022/2/14 14:52
 */
public class UdpClientDemo {
    public static void main(String[] args) throws Exception{
        DatagramSocket ds = new DatagramSocket();
        ds.setSoTimeout(1000);
        ds.connect(InetAddress.getByName("localhost"),6666);
        //发送
        byte[] data = "Hello".getBytes(StandardCharsets.UTF_8);
        DatagramPacket packet = new DatagramPacket(data, data.length);
        ds.send(packet);
        //接收
        byte[] buffer = new byte[1024];
        packet = new DatagramPacket(buffer, buffer.length);
        ds.receive(packet);
        String response = new String(packet.getData(), packet.getOffset(), packet.getLength(), StandardCharsets.UTF_8);
        System.out.println("client receive:"+response);
        ds.disconnect();
    }
}
