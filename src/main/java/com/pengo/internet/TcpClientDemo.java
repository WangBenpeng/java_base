package com.pengo.internet;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author pengo
 * @description:
 * @date 2022/2/14 10:02
 */
public class TcpClientDemo {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 6666);
        try (final InputStream is = socket.getInputStream()){
            try (final OutputStream os = socket.getOutputStream()){
                handle(is, os);
            }
        }
        socket.close();
        System.out.println("client:disconnected");
    }

    private static void handle(InputStream is, OutputStream os) throws Exception{
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(System.in);
        System.out.println("[Server] "+reader.readLine());
        for (; ; ) {
            System.out.println(">>> ");
            String s = scanner.nextLine();
            writer.write(s);
            writer.newLine();
            writer.flush();
            final String response = reader.readLine();
            System.out.println("<<< " + response);
            if (response.equals("bye"))
                break;
        }
    }
}
