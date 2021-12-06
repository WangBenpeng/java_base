package com.pengo.io.input;

import java.io.*;

/**
 * @author pengo
 * @description:
 * @date 2021/12/6 5:38 下午
 */
public class InputStreamDemo {
    public static void main(String[] args) throws Exception{
        test5();
    }

    public static void test6() throws IOException{
        byte[] data = { 72, 101, 108, 108, 111, 33 };
        try (InputStream is = new ByteArrayInputStream(data)) {
            System.out.println(readAsString(is));
        }
    }

    public static void test5() throws IOException{
        String s;
        try (InputStream is = new FileInputStream("src/main/resources/io/input/a.txt")){
            int n;
            StringBuilder sb = new StringBuilder();
            while ((n = is.read()) != -1) {
                sb.append((char) n);
            }
            s = sb.toString();
        }
        System.out.println(s);
    }

    static String readAsString(InputStream is) throws IOException{
        int n;
        StringBuilder sb = new StringBuilder();
        while ((n = is.read()) != -1) {
            sb.append((char) n);
        }
        return sb.toString();
    }

    public static void test4() throws IOException{
        byte[] data = { 72, 101, 108, 108, 111, 33 };
        try (InputStream is = new ByteArrayInputStream(data)){
            int n;
            while ((n = is.read()) != -1) {
                System.out.println((char)n);
            }
        }
    }

    public static void test3() throws IOException{
        try (InputStream is = new FileInputStream("src/main/resources/io/input/a.txt")){
            byte[] bytes = new byte[128];
            int n;
            while ((n = is.read(bytes)) != -1) {
                System.out.println(n);
            }
        }
    }

    public static void test2() throws IOException{
        try (InputStream is = new FileInputStream("src/main/resources/io/input/a.txt")){
            int n;
            while ((n = is.read()) != -1) {
                System.out.println(n);
            }
        }
    }

    public static void test1() throws IOException {
        InputStream inputStream = new FileInputStream("src/main/resources/io/input/a.txt");
        for (; ; ) {
            int n = inputStream.read();
            if (n == -1) {
                break;
            }
            System.out.println(n);
        }
        inputStream.close();
    }
}
