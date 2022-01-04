package com.pengo.security.hash;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * @author pengo
 * @description:
 * @date 2021/12/31 11:19
 */
public class HashDemo {
    public static void main(String[] args) throws Exception {
        testSha1();
    }

    public static void testSha1() throws Exception{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update("Hello".getBytes(StandardCharsets.UTF_8));
        md.update("World".getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();
        System.out.println(Arrays.toString(digest));
        System.out.println(new BigInteger(1, digest).toString(16));
    }

    public static void testMd5() throws Exception{
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update("Hello".getBytes(StandardCharsets.UTF_8));
        md.update("World".getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();
        System.out.println(Arrays.toString(digest));
        System.out.println(new BigInteger(1, digest).toString(16));
    }
}
