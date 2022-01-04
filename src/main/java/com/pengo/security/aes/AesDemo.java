package com.pengo.security.aes;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Arrays;
import java.util.Base64;

/**
 * @author pengo
 * @description:
 * @date 2021/12/31 13:45
 */
public class AesDemo {
    public static void main(String[] args) throws Exception {
        test3();
    }

    public static void test3() throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        String message = "Hello, world!";
        String password = "hello12345";
        byte[] salt = SecureRandom.getInstanceStrong().generateSeed(16);
        System.out.printf("salt: %032x\n", new BigInteger(1, salt));
        byte[] data = message.getBytes(StandardCharsets.UTF_8);
        byte[] encrypt = pbeEncrypt(password, salt, data);
        System.out.println("encrypt:" + Base64.getEncoder().encodeToString(encrypt));
        byte[] decrypt = pbeDecrypt(password, salt, encrypt);
        System.out.println("decrypted:" + new String(decrypt, StandardCharsets.UTF_8));
    }

    private static byte[] pbeEncrypt(String password, byte[] salt, byte[] input) throws Exception{
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory skeyFactory = SecretKeyFactory.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
        SecretKey skey = skeyFactory.generateSecret(keySpec);
        PBEParameterSpec pbeps = new PBEParameterSpec(salt, 1000);
        Cipher cipher = Cipher.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
        cipher.init(Cipher.ENCRYPT_MODE, skey, pbeps);
        return cipher.doFinal(input);
    }

    private static byte[] pbeDecrypt(String password, byte[] salt, byte[] input) throws Exception {
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory skeyFactory = SecretKeyFactory.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
        SecretKey skey = skeyFactory.generateSecret(keySpec);
        PBEParameterSpec pbeps = new PBEParameterSpec(salt, 1000);
        Cipher cipher = Cipher.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
        cipher.init(Cipher.DECRYPT_MODE, skey, pbeps);
        return cipher.doFinal(input);
    }

    public static void test2() throws Exception{
        String message = "Hello, world!";
        System.out.println("Message:" + message);
        byte[] key = "1234567890abcdef1234567890abcdef".getBytes(StandardCharsets.UTF_8);
        byte[] data = message.getBytes(StandardCharsets.UTF_8);
        byte[] encrypt = cbcEncrypt(key, data);
        System.out.println("Encrypted:" + Base64.getEncoder().encodeToString(encrypt));
        byte[] decrypt = cbcDecrypt(key, encrypt);
        System.out.println("Decrypted:" + new String(decrypt, StandardCharsets.UTF_8));
    }

    private static byte[] cbcEncrypt(byte[] key, byte[] input) throws Exception{
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        SecureRandom sr = SecureRandom.getInstanceStrong();
        byte[] iv = sr.generateSeed(16);
        System.out.println(Arrays.toString(iv));
        IvParameterSpec ivps = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivps);
        byte[] data = cipher.doFinal(input);
        return join(iv, data);
    }

    private static byte[] cbcDecrypt(byte[] key, byte[] input) throws Exception{
        byte[] iv = new byte[16];
        byte[] data = new byte[input.length - 16];
        System.arraycopy(input, 0, iv, 0, iv.length);
        System.arraycopy(input, iv.length, data, 0, data.length);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivps = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivps);
        return cipher.doFinal(data);
    }

    private static byte[] join(byte[] bs1, byte[] bs2) {
        byte[] r = new byte[bs1.length + bs2.length];
        System.arraycopy(bs1, 0, r, 0, bs1.length);
        System.arraycopy(bs2, 0, r, bs1.length, bs2.length);
        return r;
    }

    public static void test1() throws Exception{
        String message = "Hello World!";
        System.out.println("Message:" + message);
        byte[] key = "1234567890abcdef".getBytes(StandardCharsets.UTF_8);
        byte[] data = message.getBytes(StandardCharsets.UTF_8);
        byte[] encrypt = aesEncrypt(key, data);
        System.out.println(Arrays.toString(encrypt));
        System.out.println(new BigInteger(1, encrypt).toString(16));
        System.out.println("Encrypted:" + Base64.getEncoder().encodeToString(encrypt));
        byte[] decrypt = aesDecrypt(key, encrypt);
        System.out.println("Decrypted:" + new String(decrypt, StandardCharsets.UTF_8));
    }

    private static byte[] aesEncrypt(byte[] key, byte[] input) throws Exception{
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        cipher.update(input);
        return cipher.doFinal();
    }

    private static byte[] aesDecrypt(byte[] key, byte[] input) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        return cipher.doFinal(input);
    }
}
