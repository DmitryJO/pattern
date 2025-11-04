package ru.dm.smirnov.strategy;

/**
 * Конкретная стратегия: Праздничная скидка (20%)
 */
public class HolidayDiscountStrategy implements DiscountStrategy {
    
    private static final double DISCOUNT_PERCENT = 0.20; // 20%
    
    @Override
    public double calculatePrice(double originalPrice) {
        return originalPrice * (1 - DISCOUNT_PERCENT); // Цена минус 20%
    }
    
    @Override
    public String getDiscountName() {
        return "Праздничная скидка (20%)";
    }
}

