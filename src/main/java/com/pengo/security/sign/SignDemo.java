package com.pengo.security.sign;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;

/**
 * @author pengo
 * @description:
 * @date 2021/12/31 16:25
 */
public class SignDemo {
    public static void main(String[] args) throws Exception{
        test1();
    }

    public static void test1() throws Exception {
        KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
        kpGen.initialize(1024);
        KeyPair kp = kpGen.generateKeyPair();
        PrivateKey sk = kp.getPrivate();
        PublicKey pk = kp.getPublic();
        byte[] message = "Hello, I am Bob!".getBytes(StandardCharsets.UTF_8);

        Signature s = Signature.getInstance("SHA1withRSA");
        s.initSign(sk);
        s.update(message);
        byte[] signed = s.sign();
        System.out.println(String.format("signature: %x", new BigInteger(1, signed)));

        Signature v = Signature.getInstance("SHA1withRSA");
        v.initVerify(pk);
        v.update(message);
        boolean valid = v.verify(signed);
        System.out.println("valid?" + valid);

    }
}
