package ru.dm.smirnov;

import ru.dm.smirnov.coffee.Coffee;
import ru.dm.smirnov.enums.CoffeeType;
import ru.dm.smirnov.factory.SimpleCoffeeFactory;

public class CoffeeShop {

    private final SimpleCoffeeFactory simpleCoffeeFactory;

    public CoffeeShop(SimpleCoffeeFactory simpleCoffeeFactory) {
        this.simpleCoffeeFactory = simpleCoffeeFactory;
    }

    public void orderCoffee(CoffeeType coffeeType) {
        Coffee coffee = simpleCoffeeFactory.createCoffee(coffeeType);

        coffee.grindCoffee();
        coffee.makeCoffee();
        coffee.pourIntoCup();

        System.out.println("Вот ваш кофе! Спасибо, приходите еще!");
    }

}
