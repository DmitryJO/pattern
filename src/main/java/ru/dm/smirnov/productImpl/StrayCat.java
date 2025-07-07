package ru.dm.smirnov.productImpl;

import ru.dm.smirnov.product.Cat;

public class StrayCat implements Cat {

    @Override
    public void makePurring() {
        System.out.println("Бездомная кошка мурчит");
    }

    @Override
    public void speak() {
        System.out.println("Бездомная кошка мяукает");
    }

}
