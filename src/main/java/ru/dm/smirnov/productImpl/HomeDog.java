package ru.dm.smirnov.productImpl;

import ru.dm.smirnov.product.Dog;

public class HomeDog implements Dog {

    @Override
    public void takeBone() {
        System.out.println("Домашняя собака берет кость");
    }

    @Override
    public void speak() {
        System.out.println("Домашняя собака лает");
    }

}
