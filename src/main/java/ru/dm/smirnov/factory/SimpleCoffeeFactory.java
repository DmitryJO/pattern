package ru.dm.smirnov.factory;

import ru.dm.smirnov.coffee.Americano;
import ru.dm.smirnov.coffee.Cappuccino;
import ru.dm.smirnov.coffee.Coffee;
import ru.dm.smirnov.coffee.Espresso;
import ru.dm.smirnov.coffee.Latte;
import ru.dm.smirnov.enums.CoffeeType;

public class SimpleCoffeeFactory {

    public Coffee createCoffee(CoffeeType coffeeType) {
        Coffee coffee = null;

        switch (coffeeType) {
            case LATTE -> coffee = new Latte();
            case ESPRESSO -> coffee = new Espresso();
            case AMERICANO -> coffee = new Americano();
            case CAPPUCCINO -> coffee = new Cappuccino();
        }

        return coffee;
    }


}
