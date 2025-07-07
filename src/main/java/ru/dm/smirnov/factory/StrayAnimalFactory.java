package ru.dm.smirnov.factory;

import ru.dm.smirnov.product.Cat;
import ru.dm.smirnov.product.Dog;
import ru.dm.smirnov.productImpl.StrayCat;
import ru.dm.smirnov.productImpl.StrayDog;

public class StrayAnimalFactory implements AnimalFactory {

    @Override
    public Dog createDog() {
        return new StrayDog();
    }

    @Override
    public Cat createCat() {
        return new StrayCat();
    }

}
