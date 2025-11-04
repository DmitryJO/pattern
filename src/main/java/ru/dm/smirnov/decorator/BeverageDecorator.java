package ru.dm.smirnov.decorator;

/**
 * Абстрактный декоратор
 * 
 * Базовый класс для всех декораторов.
 * Хранит ссылку на декорируемый объект (обертку).
 */
public abstract class BeverageDecorator implements Beverage {
    protected Beverage beverage; // Декорируемый напиток
    
    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription(); // Делегируем описание базовому напитку
    }
    
    @Override
    public double getCost() {
        return beverage.getCost(); // Делегируем стоимость базовому напитку
    }
}

