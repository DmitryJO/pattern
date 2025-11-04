package ru.dm.smirnov.decorator;

/**
 * Builder для создания кофе с добавками
 * 
 * Решает проблему множественных операторов new.
 * Позволяет создавать декорированные объекты более читабельно.
 */
public class CoffeeBuilder {
    private Beverage beverage;
    
    /**
     * Начинает создание кофе с базового напитка
     */
    public CoffeeBuilder() {
        this.beverage = new SimpleCoffee();
    }
    
    /**
     * Добавляет молоко
     */
    public CoffeeBuilder withMilk() {
        beverage = new MilkDecorator(beverage);
        return this;
    }
    
    /**
     * Добавляет сахар
     */
    public CoffeeBuilder withSugar() {
        beverage = new SugarDecorator(beverage);
        return this;
    }
    
    /**
     * Добавляет взбитые сливки
     */
    public CoffeeBuilder withWhippedCream() {
        beverage = new WhippedCreamDecorator(beverage);
        return this;
    }
    
    /**
     * Возвращает готовый напиток
     */
    public Beverage build() {
        return beverage;
    }
}

