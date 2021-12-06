package com.pengo.io.output;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author pengo
 * @description:
 * @date 2021/12/6 10:18 下午
 */
public class OutputStreamDemo {
    public static void main(String[] args) throws Exception {
        test4();
    }

    public static void test4() throws IOException{
        try (InputStream is = new FileInputStream("src/main/resources/io/input/a.txt");
        OutputStream os = new FileOutputStream("src/main/resources/io/output/b.txt")){
            is.transferTo(os);
        }

    }

    public static void test3() throws IOException{
        byte[] data;
        try (ByteArrayOutputStream os = new ByteArrayOutputStream()){
            os.write("Hello".getBytes(StandardCharsets.UTF_8));
            os.write(" World".getBytes(StandardCharsets.UTF_8));
            data = os.toByteArray();
        }
        System.out.println(new String(data));
    }

    public static void test2() throws IOException {
        byte[] bytes = new byte[]{72, 101, 108, 108, 111, 33, 72};
        try (OutputStream os = new FileOutputStream("src/main/resources/io/output/b.txt")){
            os.write(bytes);
            os.flush();
        }
    }

    public static void test1() throws IOException {
        OutputStream os = new FileOutputStream("src/main/resources/io/output/b.txt");
        os.write(72);
        os.write(101);
        os.write(108);
        os.write(108);
        os.write(111);
        os.write(33);
        os.close();
    }
}
