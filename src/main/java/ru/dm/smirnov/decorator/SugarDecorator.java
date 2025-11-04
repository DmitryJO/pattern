package ru.dm.smirnov.decorator;

/**
 * Конкретный декоратор: Сахар
 * 
 * Добавляет сахар к напитку.
 */
public class SugarDecorator extends BeverageDecorator {
    
    public SugarDecorator(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", сахар";
    }
    
    @Override
    public double getCost() {
        return beverage.getCost() + 5.0; // Добавляем стоимость сахара
    }
}

