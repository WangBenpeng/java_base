package com.pengo.io.zip;

import java.io.*;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author pengo
 * @description:
 * @date 2021/12/15 21:24
 */
public class ZipStreamDemo {
    public static void main(String[] args) {
        test2();
    }

    public static void test2() {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("src/main/resources/io/zip/outputzip.zip"))){
            File[] files = new File[]{new File("src/main/resources/io/zip/a/a.txt"),new File("src/main/resources/io/zip/b.txt")};
            for (File file : files) {
                zos.putNextEntry(new ZipEntry(file.getName()));
                byte[] bytes = new byte[1024];
                FileInputStream fileInputStream = new FileInputStream(file);
                fileInputStream.read(bytes);
                zos.write(bytes);
                zos.closeEntry();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void test1() {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream("src/main/resources/io/zip/inputzip.zip"));
            ZipEntry zipEntry = null;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                String name = zipEntry.getName();
                System.out.println("name:"+name);
                if (!zipEntry.isDirectory()) {
                    int n;
                    while ((n = zipInputStream.read()) != -1) {
                        System.out.println("value:"+(char) n);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
