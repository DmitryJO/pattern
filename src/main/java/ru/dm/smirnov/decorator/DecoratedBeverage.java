package ru.dm.smirnov.decorator;

import java.util.ArrayList;
import java.util.List;

/**
 * Обертка для Beverage, которая позволяет добавлять декораторы к уже созданному объекту
 * 
 * Решает проблему невозможности добавления декораторов к существующему объекту.
 * Внутри хранит список декораторов и базовый напиток.
 */
public class DecoratedBeverage implements Beverage {
    private Beverage baseBeverage;
    private List<Class<? extends BeverageDecorator>> decoratorClasses;
    
    public DecoratedBeverage(Beverage baseBeverage) {
        this.baseBeverage = baseBeverage;
        this.decoratorClasses = new ArrayList<>();
    }
    
    /**
     * Добавляет декоратор к напитку
     * Возвращает новый объект DecoratedBeverage с добавленным декоратором
     */
    public DecoratedBeverage addMilk() {
        DecoratedBeverage result = new DecoratedBeverage(this.baseBeverage);
        result.decoratorClasses.addAll(this.decoratorClasses);
        result.decoratorClasses.add(MilkDecorator.class);
        return result;
    }
    
    public DecoratedBeverage addSugar() {
        DecoratedBeverage result = new DecoratedBeverage(this.baseBeverage);
        result.decoratorClasses.addAll(this.decoratorClasses);
        result.decoratorClasses.add(SugarDecorator.class);
        return result;
    }
    
    public DecoratedBeverage addWhippedCream() {
        DecoratedBeverage result = new DecoratedBeverage(this.baseBeverage);
        result.decoratorClasses.addAll(this.decoratorClasses);
        result.decoratorClasses.add(WhippedCreamDecorator.class);
        return result;
    }
    
    /**
     * Создает финальный декорированный объект
     */
    private Beverage buildDecorated() {
        Beverage result = baseBeverage;
        for (Class<? extends BeverageDecorator> decoratorClass : decoratorClasses) {
            try {
                if (decoratorClass == MilkDecorator.class) {
                    result = new MilkDecorator(result);
                } else if (decoratorClass == SugarDecorator.class) {
                    result = new SugarDecorator(result);
                } else if (decoratorClass == WhippedCreamDecorator.class) {
                    result = new WhippedCreamDecorator(result);
                }
            } catch (Exception e) {
                throw new RuntimeException("Ошибка создания декоратора", e);
            }
        }
        return result;
    }
    
    @Override
    public String getDescription() {
        return buildDecorated().getDescription();
    }
    
    @Override
    public double getCost() {
        return buildDecorated().getCost();
    }
    
    /**
     * Возвращает финальный декорированный напиток
     */
    public Beverage toBeverage() {
        return buildDecorated();
    }
}

