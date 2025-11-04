package ru.dm.smirnov.decorator;

/**
 * Конкретный декоратор: Молоко
 * 
 * Добавляет молоко к напитку.
 * Обертывает существующий напиток и добавляет свою функциональность.
 */
public class MilkDecorator extends BeverageDecorator {
    
    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", молоко"; // Добавляем "молоко" к описанию
    }
    
    @Override
    public double getCost() {
        return beverage.getCost() + 15.0; // Добавляем стоимость молока
    }
}

