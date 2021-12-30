package com.pengo.io.writer;

import java.io.*;

/**
 * @author pengo
 * @description:
 * @date 2021/12/30 10:36
 */
public class WriterDemo {
    public static void main(String[] args) throws Exception{
        test2();
    }

    public static void test2() throws Exception {
        try (Writer writer = new OutputStreamWriter(new FileOutputStream("src/main/resources/io/writer/b.txt"))){
            writer.write("Hello, This is OutputStreamWriter");
            writer.flush();
        }
        try (StringWriter writer = new StringWriter()) {
            writer.write("A");
            writer.write("B");
            writer.write("C");
            System.out.println(writer.toString());
        }
        try (CharArrayWriter writer = new CharArrayWriter()){
            writer.write("H");
            writer.write("E");
            writer.write("LLO");
            char[] chars = writer.toCharArray();
            System.out.println(chars);
        }
    }

    public static void test1() throws Exception {
        try (Writer writer = new FileWriter("src/main/resources/io/writer/b.txt")){
            writer.write(65);
            writer.write(66);
            writer.write(67);
            writer.write("Hello");
            writer.write("World".toCharArray());
        }
    }

}
