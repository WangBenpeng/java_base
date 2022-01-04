package com.pengo.security.dh;

import javax.crypto.KeyAgreement;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author pengo
 * @description:
 * @date 2021/12/31 15:07
 */
public class DHDemo {
    public static void main(String[] args) {
        Person bob = new Person("Bob");
        Person alice = new Person("Alice");

        bob.generateKeyPair(512);
        alice.generateKeyPair(512);

        bob.generateSecretKey(alice.publicKey.getEncoded());
        alice.generateSecretKey(bob.publicKey.getEncoded());

        bob.printKeys();
        alice.printKeys();
    }


}

class Person{
    public final String name;

    public PublicKey publicKey;
    public PrivateKey privateKey;
    private byte[] secretKey;

    public Person(String name) {
        this.name = name;
    }

    public void generateKeyPair(int keySize) {
        try {
            KeyPairGenerator kpGen = KeyPairGenerator.getInstance("DH");
            kpGen.initialize(keySize);
            KeyPair kp = kpGen.generateKeyPair();
            this.privateKey = kp.getPrivate();
            this.publicKey = kp.getPublic();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void generateSecretKey(byte[] receivedPubKeyBytes) {
        try {

            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(receivedPubKeyBytes);
            KeyFactory kf = KeyFactory.getInstance("DH");
            PublicKey receivedPublicKey = kf.generatePublic(keySpec);
            KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
            keyAgreement.init(this.privateKey);
            keyAgreement.doPhase(receivedPublicKey, true);
            this.secretKey = keyAgreement.generateSecret();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void printKeys() {
        System.out.printf("Name: %s\n", this.name);
        System.out.printf("Private key: %x\n", new BigInteger(1, this.privateKey.getEncoded()));
        System.out.printf("Public key: %x\n", new BigInteger(1, this.publicKey.getEncoded()));
        System.out.printf("Secret key: %x\n", new BigInteger(1, this.secretKey));
    }
}














