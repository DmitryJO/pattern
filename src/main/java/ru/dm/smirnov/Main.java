package ru.dm.smirnov;

import ru.dm.smirnov.factory.AnimalFactory;
import ru.dm.smirnov.factory.HomeAnimalFactory;
import ru.dm.smirnov.factory.StrayAnimalFactory;
import ru.dm.smirnov.product.Cat;
import ru.dm.smirnov.product.Dog;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Домашние животные ===");
        AnimalFactory homeFactory = new HomeAnimalFactory();

        Cat homeCat = homeFactory.createCat();
        homeCat.makePurring();
        homeCat.speak();

        Dog homeDog = homeFactory.createDog();
        homeDog.speak();
        homeDog.takeBone();

        System.out.println("\n=== Бездомные животные ===");
        AnimalFactory strayFactory = new StrayAnimalFactory();

        Cat strayCat = strayFactory.createCat();
        strayCat.makePurring();
        strayCat.speak();

        Dog strayDog = strayFactory.createDog();
        strayDog.speak();
        strayDog.takeBone();

    }

}
