package com.pengo.io.print;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author pengo
 * @description:
 * @date 2021/12/30 10:55
 */
public class PrintDemo {
    public static void main(String[] args) throws Exception{
        test2();
    }

    public static void test2() throws Exception {
        StringWriter stringWriter = new StringWriter();
        try (PrintWriter writer = new PrintWriter(stringWriter)){
            writer.println("Hello");
            writer.println(65);
            System.out.println(stringWriter.toString());
        }
    }

    public static void test1() throws Exception{
        try (PrintStream printStream = new PrintStream(new FileOutputStream("src/main/resources/io/print/stream.txt"))){
            printStream.println("Hello");
            printStream.print("World");
            System.out.println();
        }
    }
}
