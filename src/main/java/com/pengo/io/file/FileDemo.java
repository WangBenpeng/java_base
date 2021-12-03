package com.pengo.io.file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author pengo
 * @description:
 * @date 2021/12/3 10:07 下午
 */
public class FileDemo {
    public static void main(String[] args) throws Exception {
        testHomework();
    }

    public static void testHomework() {
        File file = new File("src/main/resources/file");
        File[] files = file.listFiles();
        printFile(files,0);
    }

    static void printFile(File[] files,int space) {
        space++;
        if (files != null) {
            for (File file : files) {
                for (int i = 0; i < space; i++) {
                    System.out.printf("   ");
                }
                System.out.println(file.getName());
                if (file.isDirectory()) {
                    printFile(file.listFiles(),space);
                }
            }
        }
    }

    public static void testPath() {
        Path p1 = Paths.get(".", "project", "study");
        System.out.println(p1);
        Path p2 = p1.toAbsolutePath();
        System.out.println(p2);
        Path normalize = p2.normalize();
        System.out.println(normalize);
        File file = normalize.toFile();
        System.out.println(file);
        System.out.println(file.getAbsolutePath());
        for (Path path : Paths.get("..").toAbsolutePath()) {
            System.out.println("   " + path);
        }
    }

    public static void test5() {
        File file = new File("/Users/pengo/Downloads");
        File[] files = file.listFiles();
        printFiles(files);
        File[] files2 = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".dmg");
            }
        });
        printFiles(files2);
    }

    static void printFiles(File[] files) {
        System.out.println("------");
        if (files != null) {
            for (File file : files) {
                System.out.println(file);
            }
        }
    }

    public static void test4() throws IOException {
        File file = File.createTempFile("tmp-", ".txt");
        file.deleteOnExit();
        System.out.println(file.isFile());
        System.out.println(file.getAbsolutePath());
    }

    public static void test3() throws IOException {
        File f1 = new File("src/main/resources/file/a.txt");
        System.out.println("path---> "+f1.getAbsolutePath());
        if (f1.createNewFile()) {
            System.out.println("create file successfully");
            if (f1.delete()) {
                System.out.println("delete file successfully");
            }
        }
    }

    public static void test2() {
        File f1 = new File("/Users/pengo");
        File f2 = new File("/System/Applications/Notes.app");
        File f3 = new File("/Users/abc");
        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory());
        System.out.println(f2.isFile());
        System.out.println(f2.isDirectory());
        System.out.println(f3.isFile());
        System.out.println(f3.isDirectory());
    }

    public static void test1() throws Exception {
        File file = new File("..");
        System.out.println("Path---> "+file.getPath());
        System.out.println("AbsolutePath---> "+file.getAbsolutePath());
        System.out.println("canonicalPath--->"+file.getCanonicalPath());
        System.out.println(File.separator);
    }
}
