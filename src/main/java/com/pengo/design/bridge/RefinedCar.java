package com.pengo.design.bridge;

/**
 * @author pengo
 * @description:
 * @date 2022/2/23 17:54
 */
public abstract class RefinedCar extends Car{
    public RefinedCar(Engine engine) {
        super(engine);
    }

    @Override
    public void drive() {
        this.engine.start();
        System.out.println("Drive " + getBrand() + " Car");
    }

    public abstract String getBrand();
}
