package com.pengo.io.reader;

import java.io.*;

/**
 * @author pengo
 * @description:
 * @date 2021/12/30 10:11
 */
public class ReaderDemo {
    public static void main(String[] args) throws Exception{
        test5();
    }

    public static void test5() throws Exception{
        try (Reader reader = new InputStreamReader(new FileInputStream("src/main/resources/io/reader/a.txt"))){
            int n;
            while ((n = reader.read()) != -1)
                System.out.println((char) n);
        }
    }

    public static void test4() throws Exception {
        try (Reader reader = new StringReader("Hello Reader")){
            int n;
            while ((n = reader.read()) != -1)
                System.out.println((char) n);
        }
    }

    public static void test3() throws Exception {
        try (Reader reader = new CharArrayReader("Hello".toCharArray())){
            int n;
            while ((n = reader.read()) != -1) {
                System.out.println((char) n);
            }
        }
    }

    public static void test2() throws Exception{
        try (Reader reader = new FileReader("src/main/resources/io/reader/a.txt")) {
            char[] c = new char[50];
            int n;
            while ((n = reader.read(c)) != -1) {
                System.out.println(c);
            }
        }
    }

    public static void test1() throws Exception {
        try (Reader reader = new FileReader("src/main/resources/io/reader/a.txt")){
            int n;
            while ((n = reader.read()) != -1) {
                System.out.println((char) n);
            }
        }
    }
}
