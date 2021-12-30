package com.pengo.io.files;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pengo
 * @description:
 * @date 2021/12/30 11:18
 */
public class FilesDemo {
    public static void main(String[] args) throws Exception{
        test2();
    }

    public static void test2() throws Exception {
        byte[] bytes = new byte[]{65,66,67};
        Files.write(Paths.get("src/main/resources/io/files/read.txt"), bytes);
        Files.writeString(Paths.get("src/main/resources/io/files/read.txt"), "Hello World", StandardCharsets.UTF_8);
        List<String> lines = new ArrayList<>();
        lines.add("A");
        lines.add("B");
        lines.add("C");
        Files.write(Paths.get("src/main/resources/io/files/read.txt"), lines);
    }

    public static void test1() throws Exception{
        String result = Files.readString(Paths.get("src/main/resources/io/files/read.txt"));
        System.out.println(result);
        byte[] bytes = Files.readAllBytes(Paths.get("src/main/resources/io/files/read.txt"));
        System.out.println(bytes);
        List<String> list = Files.readAllLines(Paths.get("src/main/resources/io/files/read.txt"));
        System.out.println(list);
    }
}
