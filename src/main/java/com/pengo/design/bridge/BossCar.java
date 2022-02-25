package com.pengo.design.bridge;

/**
 * @author pengo
 * @description:
 * @date 2022/2/23 17:56
 */
public class BossCar extends RefinedCar{
    public BossCar(Engine engine) {
        super(engine);
    }

    @Override
    public String getBrand() {
        return "Boss";
    }
}
