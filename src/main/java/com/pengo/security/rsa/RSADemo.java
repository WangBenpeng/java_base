package com.pengo.security.rsa;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author pengo
 * @description:
 * @date 2021/12/31 16:10
 */
public class RSADemo {
    public static void main(String[] args) throws Exception {
        byte[] plain = "Hello, encrypt use RSA".getBytes(StandardCharsets.UTF_8);
        Person alice = new Person("Alice");
        byte[] pk = alice.getPublicKey();
        System.out.println(String.format("public key: %x", new BigInteger(1, pk)));
        byte[] encrypt = alice.encrypt(plain);
        System.out.println(String.format("encrypted: %x", new BigInteger(1, encrypt)));
        byte[] sk = alice.getPrivateKey();
        System.out.println(String.format("private key: %x", new BigInteger(1, sk)));
        byte[] decrypt = alice.decrypt(encrypt);
        System.out.println(new String(decrypt,StandardCharsets.UTF_8));
    }
}

class Person{
    String name;

    PublicKey pk;
    PrivateKey sk;

    public Person(String name) throws Exception{
        this.name = name;
        KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
        kpGen.initialize(1024);
        KeyPair keyPair = kpGen.generateKeyPair();
        this.pk = keyPair.getPublic();
        this.sk = keyPair.getPrivate();
    }

    public byte[] getPrivateKey() {
        return this.sk.getEncoded();
    }

    public byte[] getPublicKey() {
        return this.pk.getEncoded();
    }

    public byte[] encrypt(byte[] message) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, this.pk);
        return cipher.doFinal(message);
    }

    public byte[] decrypt(byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, this.sk);
        return cipher.doFinal(data);
    }

}