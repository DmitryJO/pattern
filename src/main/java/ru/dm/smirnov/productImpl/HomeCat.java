package ru.dm.smirnov.productImpl;

import ru.dm.smirnov.product.Cat;

public class HomeCat implements Cat {

    @Override
    public void makePurring() {
        System.out.println("Домашняя кошка мурчит");
    }

    @Override
    public void speak() {
        System.out.println("Домашняя кошка мяукает");
    }

}
