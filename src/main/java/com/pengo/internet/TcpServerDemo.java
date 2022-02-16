package com.pengo.internet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author pengo
 * @description:
 * @date 2022/2/14 09:43
 */
public class TcpServerDemo {
    public static void main(String[] args) throws Exception{
        ServerSocket socket = new ServerSocket(6666);
        System.out.println("server is running...");
        for (; ; ) {
            Socket s2 = socket.accept();
            System.out.println("connected from: "+s2.getRemoteSocketAddress());
            Thread t = new Handler(s2);
            t.start();
        }
    }
}


class Handler extends Thread {
    Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = this.socket.getInputStream()) {
            try (OutputStream outputStream = this.socket.getOutputStream()) {
                handle(inputStream, outputStream);
            }
        } catch (Exception e) {
            try {
                this.socket.close();
            } catch (IOException ioException) {
            }
            System.out.println("client disconnect");
        }
    }

    private void handle(InputStream is,OutputStream os) throws Exception{
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        writer.write("hello\n");
        writer.flush();
        for (; ; ) {
            String s = reader.readLine();
            if (s.equals("bye")) {
                writer.write("bye\n");
                writer.flush();
                break;
            }
            writer.write("ok:"+s+"\n");
            writer.flush();
        }
    }
}