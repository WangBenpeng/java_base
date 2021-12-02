package com.pengo.collection.properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * @author pengo
 * @description:
 * @date 2021/12/1 3:58 下午
 */
public class PropertiesDemo {
    public static void main(String[] args) throws Exception {
        PropertiesDemo demo = new PropertiesDemo();
        demo.test1();
    }

    public void test1() throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/main/resources/prop.properties"));
        System.out.println(prop.getProperty("last_open_file"));
        prop.setProperty("auto_save_interval", "240");
        prop.store(new FileOutputStream("src/main/resources/prop.properties"),"this is a comment");

        Properties prop2 = new Properties();
        prop2.load(this.getClass().getResourceAsStream("/prop.properties"));
        System.out.println(prop2.getProperty("auto_save_interval"));
        System.out.println(prop2.getProperty("name", "user"));
    }

    public void testResource() {
        System.out.println(this.getClass().getClassLoader().getResource("prop.properties"));
        System.out.println(this.getClass().getResource("/prop.properties"));
    }
}
