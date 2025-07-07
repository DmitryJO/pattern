package ru.dm.smirnov.factory;

import ru.dm.smirnov.product.Cat;
import ru.dm.smirnov.product.Dog;
import ru.dm.smirnov.productImpl.HomeCat;
import ru.dm.smirnov.productImpl.HomeDog;

public class HomeAnimalFactory implements AnimalFactory {

    @Override
    public Dog createDog() {
        return new HomeDog();
    }

    @Override
    public Cat createCat() {
        return new HomeCat();
    }

}
