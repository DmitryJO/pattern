package ru.dm.smirnov.factory;

import ru.dm.smirnov.product.Cat;
import ru.dm.smirnov.product.Dog;

/**
 * Абстрактная фабрика для создания семейства животных
 * Паттерн Абстрактная фабрика позволяет создавать семейства связанных объектов
 */
public interface AnimalFactory {

    /**
     * Создает собаку
     * @return экземпляр собаки
     */
    Dog createDog();

    /**
     * Создает кошку
     * @return экземпляр кошки
     */
    Cat createCat();

}
