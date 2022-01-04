package com.pengo.security.encode;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author pengo
 * @description:
 * @date 2021/12/31 10:46
 */
public class UrlEncodeDemo {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        String encode = URLEncoder.encode("中文！", StandardCharsets.UTF_8);
        System.out.println(encode);
        String decode = URLDecoder.decode(encode, StandardCharsets.UTF_8);
        System.out.println(decode);
    }
}
