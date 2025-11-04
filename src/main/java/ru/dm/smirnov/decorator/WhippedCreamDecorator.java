package ru.dm.smirnov.decorator;

/**
 * Конкретный декоратор: Взбитые сливки
 * 
 * Добавляет взбитые сливки к напитку.
 */
public class WhippedCreamDecorator extends BeverageDecorator {
    
    public WhippedCreamDecorator(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", взбитые сливки";
    }
    
    @Override
    public double getCost() {
        return beverage.getCost() + 20.0; // Добавляем стоимость взбитых сливок
    }
}

