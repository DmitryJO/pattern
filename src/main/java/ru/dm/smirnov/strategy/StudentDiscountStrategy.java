package ru.dm.smirnov.strategy;

/**
 * Конкретная стратегия: Скидка для студентов (10%)
 */
public class StudentDiscountStrategy implements DiscountStrategy {
    
    private static final double DISCOUNT_PERCENT = 0.10; // 10%
    
    @Override
    public double calculatePrice(double originalPrice) {
        return originalPrice * (1 - DISCOUNT_PERCENT); // Цена минус 10%
    }
    
    @Override
    public String getDiscountName() {
        return "Скидка для студентов (10%)";
    }
}

