package com.pengo.io.serialize;

import java.io.*;
import java.util.Arrays;

/**
 * @author pengo
 * @description:
 * @date 2021/12/16 23:13
 */
public class SerializableDemo {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(buffer)){
            oos.writeInt(123);
            oos.writeUTF("Hello");
            oos.writeObject(Double.valueOf("123.456"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(buffer.toByteArray()));

        ByteArrayInputStream bis = new ByteArrayInputStream(buffer.toByteArray());
        try (ObjectInputStream ois = new ObjectInputStream(bis)){
//            int a = ois.readInt();
//            String b = ois.readUTF();
//            Double c = (Double) ois.readObject();
//            System.out.println(a);
//            System.out.println(b);
//            System.out.println(c);
            System.out.println(ois.readInt());
            System.out.println(ois.readUTF());
            System.out.println((Double) ois.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
