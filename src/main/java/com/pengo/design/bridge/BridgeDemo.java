package com.pengo.design.bridge;

/**
 * @author pengo
 * @description:
 * @date 2022/2/23 17:57
 */
public class BridgeDemo {
    public static void main(String[] args) {
        Car car = new BossCar(new HybridEngine());
        car.drive();
    }
}
