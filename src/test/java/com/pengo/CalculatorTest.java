package com.pengo;

import com.pengo.junit.Calculator;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author pengo
 * @description:
 * @date 2021/12/31 09:32
 */
public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        Assert.assertEquals(100, calculator.add(100));
        Assert.assertEquals(150, calculator.add(50));
        Assert.assertEquals(100, calculator.add(-50));
    }

    @Test
    public void testSub() {
        Assert.assertEquals(-100, calculator.sub(100));
        Assert.assertEquals(-150, calculator.sub(50));
        Assert.assertEquals(-100, calculator.sub(-50));
    }
}
