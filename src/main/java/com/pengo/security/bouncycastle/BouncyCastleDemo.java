package com.pengo.security.bouncycastle;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.Security;

/**
 * @author pengo
 * @description:
 * @date 2021/12/31 11:42
 */
public class BouncyCastleDemo {
    public static void main(String[] args) throws Exception{
        test1();
    }

    public static void test1() throws Exception{
        Security.addProvider(new BouncyCastleProvider());
        MessageDigest ripeMD160 = MessageDigest.getInstance("RipeMD160");
        ripeMD160.update("Hello".getBytes(StandardCharsets.UTF_8));
        ripeMD160.update("World".getBytes(StandardCharsets.UTF_8));
        byte[] digest = ripeMD160.digest();
        System.out.println(new BigInteger(1, digest).toString(16));
    }
}
