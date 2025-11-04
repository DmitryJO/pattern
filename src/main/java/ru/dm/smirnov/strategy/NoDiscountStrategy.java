package ru.dm.smirnov.strategy;

/**
 * Конкретная стратегия: Без скидки
 */
public class NoDiscountStrategy implements DiscountStrategy {
    
    @Override
    public double calculatePrice(double originalPrice) {
        return originalPrice; // Без скидки - возвращаем исходную цену
    }
    
    @Override
    public String getDiscountName() {
        return "Без скидки";
    }
}

