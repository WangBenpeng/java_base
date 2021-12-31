package com.pengo;

import com.pengo.junit.TestDemo;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author pengo
 * @description:
 * @date 2021/12/30 18:02
 */
public class DemoTest {

    @Test(expected = Throwable.class)
    public void test2() {
        Assert.assertEquals(5109094217170944000L, TestDemo.fact(21));
    }

    @Test
    public void test1() {
        System.out.println("Hello, this is Test");
        Assert.assertTrue(true);
        Assert.assertEquals(1, TestDemo.fact(1));
        Assert.assertEquals(2, TestDemo.fact(2));
        Assert.assertEquals(2, TestDemo.fact(3));

    }
}
