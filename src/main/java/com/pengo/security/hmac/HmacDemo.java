package com.pengo.security.hmac;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author pengo
 * @description:
 * @date 2021/12/31 13:21
 */
public class HmacDemo {
    public static void main(String[] args) throws Exception{
        test2();
    }

    public static void test2() throws Exception{
        byte[] hkey = new byte[] { 106, 70, -110, 125, 39, -20, 52, 56, 85, 9, -19, -72, 52, -53, 52, -45, -6, 119, -63,
                30, 20, -83, -28, 77, 98, 109, -32, -76, 121, -106, 0, -74, -107, -114, -45, 104, -104, -8, 2, 121, 6,
                97, -18, -13, -63, -30, -125, -103, -80, -46, 113, -14, 68, 32, -46, 101, -116, -104, -81, -108, 122,
                89, -106, -109 };
        SecretKeySpec secretKeySpec = new SecretKeySpec(hkey, "HmacMD5");
        Mac hmacMD5 = Mac.getInstance("HmacMD5");
        hmacMD5.init(secretKeySpec);
        hmacMD5.update("HelloWorld".getBytes(StandardCharsets.UTF_8));
        byte[] bytes = hmacMD5.doFinal();
        System.out.println(Arrays.toString(bytes));
        System.out.println(new BigInteger(1, bytes).toString(16));

    }

    public static void test1() throws Exception{
        KeyGenerator hmacMD5 = KeyGenerator.getInstance("HmacMD5");
        SecretKey secretKey = hmacMD5.generateKey();
        byte[] encoded = secretKey.getEncoded();
        System.out.println(new BigInteger(1, encoded).toString(16));
        Mac hmacMD51 = Mac.getInstance("HmacMD5");
        hmacMD51.init(secretKey);
        hmacMD51.update("HelloWorld".getBytes(StandardCharsets.UTF_8));
        byte[] bytes = hmacMD51.doFinal();
        System.out.println(new BigInteger(1, bytes).toString(16));
    }
}
