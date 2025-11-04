package ru.dm.smirnov.decorator;

/**
 * Конкретный компонент: Простой кофе
 * 
 * Это базовый объект, который мы будем декорировать.
 */
public class SimpleCoffee implements Beverage {
    
    @Override
    public String getDescription() {
        return "Простой кофе";
    }
    
    @Override
    public double getCost() {
        return 50.0; // Базовая цена кофе
    }
}

