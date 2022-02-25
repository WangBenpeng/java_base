package com.pengo.design.bridge;

/**
 * @author pengo
 * @description:
 * @date 2022/2/23 17:52
 */
public abstract class Car {
    protected Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public abstract void drive();
}
