package com.pengo.security.encode;

import java.util.Arrays;
import java.util.Base64;

/**
 * @author pengo
 * @description:
 * @date 2021/12/31 10:48
 */
public class Base64Demo {
    public static void main(String[] args) {
        test3();
    }

    public static void test3() {
        byte[] input = new byte[] { 0x01, 0x02, 0x7f, 0x00 };
        String s = Base64.getUrlEncoder().encodeToString(input);
        System.out.println(s);
        byte[] decode = Base64.getUrlDecoder().decode(s);
        System.out.println(Arrays.toString(decode));
    }

    public static void test2() {
        byte[] input = new byte[]{(byte) 0xe4, (byte) 0xb8, (byte) 0xad, 0x21};
        String s1 = Base64.getEncoder().encodeToString(input);
        String s2 = Base64.getEncoder().withoutPadding().encodeToString(input);
        System.out.println(s1);
        System.out.println(s2);
        byte[] decode = Base64.getDecoder().decode(s1);
        byte[] decode1 = Base64.getDecoder().decode(s2);
        System.out.println(Arrays.toString(decode));
        System.out.println(Arrays.toString(decode1));
    }

    public static void test1() {
        byte[] input = new byte[]{(byte) 0xe4, (byte) 0xb8, (byte) 0xad};
        String s = Base64.getEncoder().encodeToString(input);
        System.out.println(s);
        byte[] decode = Base64.getDecoder().decode(s);
        String s1 = Arrays.toString(decode);
        System.out.println(s1);
    }
}
