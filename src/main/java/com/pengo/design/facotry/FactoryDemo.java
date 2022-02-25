package com.pengo.design.facotry;

/**
 * @author pengo
 * @description:
 * @date 2022/2/23 15:05
 */
public class FactoryDemo {
    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        NumberFactory factory = NumberFactory.getFactory();
        System.out.println(factory.parse("1234.5678"));
        System.out.println(factory.parse2date(20220223));
    }
}
