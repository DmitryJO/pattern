package ru.dm.smirnov.productImpl;

import ru.dm.smirnov.product.Dog;

public class StrayDog implements Dog {

    @Override
    public void takeBone() {
        System.out.println("Бездомная собака берет кость");
    }

    @Override
    public void speak() {
        System.out.println("Бездомная собака лает");
    }

}
