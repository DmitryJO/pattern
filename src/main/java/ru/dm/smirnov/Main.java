package ru.dm.smirnov;

import ru.dm.smirnov.enums.CoffeeType;
import ru.dm.smirnov.factory.SimpleCoffeeFactory;

public class Main {

    public static void main(String[] args) {

        CoffeeShop shop = new CoffeeShop(new SimpleCoffeeFactory());

        shop.orderCoffee(CoffeeType.LATTE);
    }

}
